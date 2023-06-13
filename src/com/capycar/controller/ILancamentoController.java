/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Lancamento;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public interface ILancamentoController {
    
    public void criarLancamento(Lancamento lancamento);
    
    public ResultSet consultarLancamento(String table);
    
}
