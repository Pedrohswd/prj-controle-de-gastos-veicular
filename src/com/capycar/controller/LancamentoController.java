/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import com.capycar.persistence.LancamentoDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class LancamentoController implements ILancamentoController {

    LancamentoDAO lancamentoDAO = new LancamentoDAO();

    @Override
    public void criarLancamento(Lancamento lancamento) {
        lancamentoDAO.criarLancamento(lancamento);
    }

    @Override
    public ResultSet consultarLancamento(String table) {
        return lancamentoDAO.consultarLancamento(table);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria,
            Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(veiculo, categoria, subcategoria, dataInicio, dataFim);
    }

    @Override
    public void alterarLancamento(Lancamento lancamento) {
        lancamentoDAO.alterarLancamento(lancamento);
    }

    @Override
    public void excluirLancamento(Lancamento lancamento) {
        lancamentoDAO.excluirLancamento(lancamento);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(categoria, subcategoria, dataInicio, dataFim);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Subcategoria subcategoria, Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(subcategoria, dataInicio, dataFim);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(dataInicio, dataFim);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(veiculo, dataInicio, dataFim);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Categoria categoria, Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(veiculo, categoria, dataInicio, dataFim);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Subcategoria subcategoria, Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(veiculo, subcategoria, dataInicio, dataFim);
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Categoria categoria, Date dataInicio, Date dataFim) {
        return lancamentoDAO.consultarLancamento(categoria, dataInicio, dataFim);
    }

}
