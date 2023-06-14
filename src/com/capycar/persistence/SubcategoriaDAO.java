/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

/**
 *
 * @author educa
 */
import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Subcategoria;
import java.sql.*;
import javax.swing.JOptionPane;

public class SubcategoriaDAO implements ISubcategoriaDAO{
    
    private java.sql.Connection conexao = null;

    public SubcategoriaDAO() {
        conexao = GastoRiderAPI.conectBD();
    }
    

    @Override
    public void incluirSubcategoria(Subcategoria subcategoria) {
        try {
            String sql = "INSERT INTO Subcategoria (Descricao, ID_CATEGORIA)" + "VALUES(?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, subcategoria.getDescricao());
            preparedStatement.setInt(2, subcategoria.getIdCategoria().getidCategoria());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void alterarSubcategoria(Subcategoria subcategoria) {
       try {
            String sql = "UPDATE Subcategoria SET Descricao = ? , ID_CATEGORIA =? WHERE ID_SUBCATEGORIA = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, subcategoria.getDescricao());
            preparedStatement.setInt(2, subcategoria.getIdCategoria().getidCategoria());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void excluirSubcategoria(Subcategoria subcategoria) {
        try {
            String sql = "DELETE FROM Subcategoria WHERE ID_SUBCATEGORIA = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, subcategoria.getIdSubcategoria());
            preparedStatement.executeUpdate();   
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public ResultSet carregTabela(String tabela) {
       try {
            PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM "+ tabela);
            ResultSet resultSet;
            return resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
