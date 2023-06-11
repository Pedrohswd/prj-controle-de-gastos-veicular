/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Categoria;
import java.sql.*;
import javax.swing.JOptionPane;

public class CategoriaDAO implements ICategoriaDAO {

    private java.sql.Connection conexao = null;

    public CategoriaDAO() {
        conexao = GastoRiderAPI.conectBD();
    }

    @Override
    public void incluirCategoria(Categoria categoria) {
        try {
            String sql = "INSERT INTO Categoria (Descricao, Tipo, categoria_pai)" + "VALUES(?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getDescricao());
            preparedStatement.setString(2, categoria.getTipo());
            preparedStatement.setString(3, categoria.getCategoria());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void alterarCategoria(Categoria categoria) {
        try {
            String sql = "UPDATE Categoria SET Descricao = ?, Tipo = ? , categoria_pai = ? WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getDescricao());
            preparedStatement.setString(2, categoria.getTipo());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
    
    @Override
    public void excluirCategoria(Categoria categoria){
        try {
            String sql = "DELETE FROM Categoria SET Descricao = ?, Tipo = ?, categoria_pai = ? WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getDescricao());
            preparedStatement.executeUpdate();   
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
    @Override
    public ResultSet carregTabela(String tabela){
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