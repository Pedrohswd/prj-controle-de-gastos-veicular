/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import com.capycar.persistence.RelatorioGraficoDAO;
import com.capycar.report.Report;
import java.util.ArrayList;
import java.util.Date;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author pedro
 */
public class ReportController implements IReportController {
    
    @Override
    public void gerarRelatorioPdf(String cpfCnpjProprietario, String nomeProprietario, String veiculo, String categoria, String subcategoria, String dataInicio, String dataFim, ArrayList<Lancamento> lancamentoLista) {
        Report report = new Report();
        report.gerar(cpfCnpjProprietario, nomeProprietario, veiculo, categoria, subcategoria, dataInicio, dataFim, lancamentoLista);
    }

    @Override
    public ChartPanel gerarRelatorioGrafico(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim) {
        RelatorioGraficoDAO relatorioGraficoDAO = new RelatorioGraficoDAO();
        return relatorioGraficoDAO.gerarGrafico(veiculo, categoria, subcategoria, dataInicio, dataFim);
    }
    
}
