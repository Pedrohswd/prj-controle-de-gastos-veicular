/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author pedro
 */
public interface ILancamentoController {
    
    public void criarLancamento(Lancamento lancamento);
    
    public ResultSet consultarLancamento(String table);
    
    public ResultSet consultarLancamento(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim);
    
}
