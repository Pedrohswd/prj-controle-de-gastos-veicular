/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Lancamento;
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

}
