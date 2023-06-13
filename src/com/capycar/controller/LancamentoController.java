/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Lancamento;
import com.capycar.persistence.LancamentoDAO;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public class LancamentoController implements ILancamentoController{
    
    LancamentoDAO lancamentoDAO = new LancamentoDAO();

    @Override
    public void criarLancamento(Lancamento lancamento) {
        lancamentoDAO.criarLancamento(lancamento);
    }

    @Override
    public ResultSet consultarLancamento(String table) {
        return lancamentoDAO.consultarLancamento(table);
    }
    
}
