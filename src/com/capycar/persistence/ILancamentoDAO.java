/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pedro
 */
public interface ILancamentoDAO {

    public void criarLancamento(Lancamento lancamento);

    public ResultSet consultarLancamento(String table);

    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Subcategoria subcategoria, Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Categoria categoria, Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Subcategoria subcategoria, Date dataInicio, Date dataFim);

    public ArrayList<Lancamento> consultarLancamento(Categoria categoria, Date dataInicio, Date dataFim);

    public void alterarLancamento(Lancamento lancamento);

    public void excluirLancamento(Lancamento lancamento);

}
