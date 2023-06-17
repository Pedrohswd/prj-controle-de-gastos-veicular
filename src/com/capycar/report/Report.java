package com.capycar.report;

import com.capycar.model.Lancamento;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Color;
import java.awt.color.ColorSpace;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Report {

    public Report() {
    }

    public static void gerar(String cpfCnpjProprietario, String nomeProprietario, String veiculo, String categoria, String subcategoria, String dataInicio, String dataFim, ArrayList<Lancamento> lancamentoLista) {
        String title = "Relatório de Gasto Veicular";
        String companyName = "CAPYCAR";
        String cpfCnpj = "CPF/CNPJ: " + cpfCnpjProprietario;
        String owner = "Proprietário: " + nomeProprietario;
        String vehicle = "Veículo: " + veiculo;
        String category = "Categoria: " + categoria;
        String subcategory = "Subcategoria: " + subcategoria;
        String period = "Período: " + dataInicio + " à " + dataFim;
        double valorTotal = 0;

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));
            document.open();

            // Fontes
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18f);
            Font companyFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12f);
            Font selectionTopicFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12f);
            Font capycar = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14f);
            capycar.setColor(BaseColor.GRAY);
            Font subTotal = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11f);
            subTotal.setColor(BaseColor.BLUE);
            selectionTopicFont.setColor(BaseColor.BLACK);
            Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12f);

            // Título
            Paragraph titleParagraph = new Paragraph(title, titleFont);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            // Nome da empresa
            Paragraph companyParagraph = new Paragraph(companyName);
            companyParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(companyParagraph);

            document.add(new Paragraph("\n"));

            // Tópico de seleção
            Chunk selectionTopicChunk = new Chunk("Critério de Seleção", selectionTopicFont);
            Chunk grayBackgroundChunk = new Chunk();
            grayBackgroundChunk.setBackground(BaseColor.LIGHT_GRAY);
            Paragraph selectionTopicParagraph = new Paragraph(selectionTopicChunk);
            selectionTopicParagraph.add(grayBackgroundChunk);
            document.add(selectionTopicParagraph);

            // Campos de dados
            document.add(new Paragraph(cpfCnpj, companyFont));
            document.add(new Paragraph(owner, companyFont));
            document.add(new Paragraph(vehicle, companyFont));
            document.add(new Paragraph(category, companyFont));
            document.add(new Paragraph(subcategory, companyFont));
            document.add(new Paragraph(period, companyFont));

            document.add(new Paragraph("\n"));

            // Linha tracejada
            LineSeparator dashedLine = new LineSeparator();
            dashedLine.setOffset(-2);
            Paragraph lineParagraph = new Paragraph();
            lineParagraph.add(dashedLine);
            document.add(lineParagraph);

            int veiculoAnterior = 0;
            PdfPTable table = null;
            int proximoItem = 0;
            int currentIndex = 0;
            double valorPorCarro = 0;
            for (Lancamento lancamento : lancamentoLista) {
                int compare = lancamento.getVeiculo().getIdVeiculo();
                currentIndex++;
                if (compare != veiculoAnterior) {
                    document.add(new Paragraph("\n"));
                    //Setando placa no topo da tabela
                    document.add(new Paragraph(lancamento.getVeiculo().toString(), companyFont));

                    dashedLine = new LineSeparator();
                    dashedLine.setOffset(-2);
                    lineParagraph = new Paragraph();
                    lineParagraph.add(dashedLine);
                    document.add(lineParagraph);

                    document.add(new Paragraph("\n"));

                    // Tabela
                    table = new PdfPTable(5);
                    table.setWidthPercentage(100);
                    table.getDefaultCell().setBorderColor(BaseColor.WHITE);
                    table.getDefaultCell().setBorderColorTop(BaseColor.WHITE);
                    table.setWidths(new float[]{13, 20, 24, 24, 15});

                    // Cabeçalho da tabela
                    PdfPCell headerCell1 = new PdfPCell(new Phrase("Sequencial", tableHeaderFont));
                    PdfPCell headerCell2 = new PdfPCell(new Phrase("Data", tableHeaderFont));
                    PdfPCell headerCell3 = new PdfPCell(new Phrase("Categoria", tableHeaderFont));
                    PdfPCell headerCell4 = new PdfPCell(new Phrase("Subcategoria", tableHeaderFont));
                    PdfPCell headerCell5 = new PdfPCell(new Phrase("Valor", tableHeaderFont));

                    table.addCell(headerCell1);
                    table.addCell(headerCell2);
                    table.addCell(headerCell3);
                    table.addCell(headerCell4);
                    table.addCell(headerCell5);
                }
                table.addCell(lancamento.getIdLancamento() + "");
                table.addCell(lancamento.getDataRegistro().toString());
                table.addCell(lancamento.getCategoria().toString());
                table.addCell(lancamento.getSubCategoria().toString());
                table.addCell(lancamento.getValor() + "");
                veiculoAnterior = lancamento.getVeiculo().getIdVeiculo();
                valorPorCarro += lancamento.getValor();
                

                if (currentIndex <= lancamentoLista.size() - 1) {
                    proximoItem = lancamentoLista.get(currentIndex).getVeiculo().getIdVeiculo();
                    if (veiculoAnterior != proximoItem) {
                        document.add(table);
                        Paragraph subtotal = new Paragraph("SubTotal: " + valorPorCarro, subTotal);
                        subtotal.setAlignment(Element.ALIGN_RIGHT);
                        document.add(subtotal);
                        document.add(new Paragraph("\n"));
                        valorTotal += valorPorCarro;
                        valorPorCarro = 0;
                        
                        dashedLine = new LineSeparator();
                        dashedLine.setOffset(-2);
                        lineParagraph = new Paragraph();
                        lineParagraph.add(dashedLine);
                        document.add(lineParagraph);

                        document.add(new Paragraph("\n"));
                    }
                } else {
                    document.add(table);
                    Paragraph subtotal = new Paragraph("SubTotal: " + valorPorCarro, subTotal);
                    subtotal.setAlignment(Element.ALIGN_RIGHT);
                    document.add(subtotal);
                    document.add(new Paragraph("\n"));
                    valorTotal += valorPorCarro;
                    valorPorCarro = 0;
                    dashedLine = new LineSeparator();
                    dashedLine.setOffset(-2);
                    lineParagraph = new Paragraph();
                    lineParagraph.add(dashedLine);
                    document.add(lineParagraph);

                    document.add(new Paragraph("\n"));
                }

            }
            Paragraph total = new Paragraph("Total: " + valorTotal, companyFont);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.close();

            System.out.println("Relatório criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
