/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import java.util.ArrayList;
import java.util.Date;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author pedro
 */
public interface IReportController {

    public ChartPanel gerarRelatorioGrafico(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim);
    public void gerarRelatorioPdf(String cpfCnpjProprietario, String nomeProprietario, String veiculo, String categoria, String subcategoria, String dataInicio, String dataFim, ArrayList<Lancamento> lancamentoLista);
}
