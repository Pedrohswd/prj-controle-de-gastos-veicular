/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Lancamento;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IReportController {

    public void gerarRelatorioPdf(String cpfCnpjProprietario, String nomeProprietario, String veiculo, String categoria, String subcategoria, String dataInicio, String dataFim, ArrayList<Lancamento> lancamentoLista);
}
