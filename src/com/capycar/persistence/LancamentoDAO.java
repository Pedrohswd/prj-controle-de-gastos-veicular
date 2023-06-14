/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class LancamentoDAO implements ILancamentoDAO {

    private java.sql.Connection connection = null;

    public LancamentoDAO() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void criarLancamento(Lancamento lancamento) {

        try {
            Date date = new Date(lancamento.getDataRegistro().getTime());
            String sql = "INSERT INTO Lancamento (ID_VEICULO, ID_CATEGORIA, ID_SUBCATEGORIA, valor, data_lancamento) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lancamento.getVeiculo().getIdVeiculo());
            preparedStatement.setInt(2, lancamento.getCategoria().getidCategoria());
            preparedStatement.setInt(3, lancamento.getSubCategoria().getIdSubcategoria());
            preparedStatement.setFloat(4, lancamento.getValor());
            preparedStatement.setDate(5, date);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lançamento feito com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ResultSet consultarLancamento(String table) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table);
            ResultSet resultSet;
            return resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet consultarLancamento(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria,
            java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            String sql = "SELECT * FROM Lancamento WHERE ID_VEICULO = ? AND ID_CATEGORIA = ? AND ID_SUBCATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, veiculo.getIdVeiculo());
            statement.setInt(2, categoria.getidCategoria());
            statement.setInt(3, subcategoria.getIdSubcategoria());
            statement.setDate(4, dateInicio);
            statement.setDate(5, dateFim);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
