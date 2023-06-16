/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Lancamento;
import com.capycar.report.Report;
import java.util.ArrayList;

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
    
}
