/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.controller.LancamentoController;
import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author educa
 */
public class RelatorioGraficoDAO implements IRelatorioGraficoDAO {

    private java.sql.Connection connection = null;
    LancamentoController lancamentoControle = new LancamentoController();

    public RelatorioGraficoDAO() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public ChartPanel gerarGrafico(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim) {
        ArrayList<Lancamento> listLancamento = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Lancamento WHERE ID_VEICULO = ? AND ID_CATEGORIA = ? AND ID_SUBCATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            java.sql.Date dateInicio = new java.sql.Date(dataInicio.getTime());
            java.sql.Date dateFim = new java.sql.Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, veiculo.getIdVeiculo());
            statement.setInt(2, categoria.getidCategoria());
            statement.setInt(3, subcategoria.getIdSubcategoria());
            statement.setDate(4, dateInicio);
            statement.setDate(5, dateFim);
            ResultSet resultSet = statement.executeQuery();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();


            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                veiculo = new Veiculo();
                categoria = new Categoria();
                subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = lancamentoControle.consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = lancamentoControle.consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = lancamentoControle.consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            for (Lancamento lancamento : listLancamento) {
                dataset.setValue(lancamento.getValor(),"Valor",lancamento.getDataRegistro());
            }

            JFreeChart chart = ChartFactory.createBarChart("Gasto no Mês", "Data", "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer render = new BarRenderer();
            CategoryPlot plot = null;
            ChartPanel panel = new ChartPanel(chart);

            return panel;
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioGraficoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
