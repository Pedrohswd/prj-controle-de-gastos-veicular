/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Modelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class ModeloDao implements IModeloDao {

    private java.sql.Connection connection = null;

    public ModeloDao() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void criarModelo(Modelo modelo) {
        try {
            String imagePath = modelo.getUrl();
            String sql = "INSERT INTO Modelo (Nome, Imagem, ID_MARCA)\n"
                    + "VALUES (?, ?, ?);";
            FileInputStream inputStream = new FileInputStream(new File(imagePath));
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, modelo.getNome());
            preparedStatement.setBinaryStream(2, inputStream);
            preparedStatement.setInt(3, modelo.getIdMarca().getIdMarca());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletarModelo(Modelo modelo) {
        try {
            String sql = "DELETE FROM Modelo WHERE ID_MODELO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, modelo.getIdModelo());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void alterarModelo(Modelo modelo) {
        try {
            if (modelo.getUrl() != null) {
                String sql = "UPDATE Modelo SET Nome = ?, Imagem = ?, ID_MARCA = ? WHERE ID_MODELO = ?";
                String imagePath = modelo.getUrl();
                FileInputStream inputStream = new FileInputStream(new File(imagePath));
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, modelo.getNome());
                preparedStatement.setBinaryStream(2, inputStream);
                preparedStatement.setInt(3, modelo.getIdMarca().getIdMarca());
                preparedStatement.setInt(4, modelo.getIdModelo());
                preparedStatement.executeUpdate();
            } else {
                String sql = "UPDATE Modelo SET Nome = ?, ID_MARCA = ? WHERE ID_MODELO = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, modelo.getNome());
                preparedStatement.setInt(2, modelo.getIdMarca().getIdMarca());
                preparedStatement.setInt(3, modelo.getIdModelo());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet carregTabela(String table) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table);
            ResultSet resultSet;
            return resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Modelo buscarModeloPorId(int idModelo) {
    try {
        String sql = "SELECT * FROM Modelo WHERE ID_MODELO = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idModelo);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Modelo modelo = new Modelo();
            modelo.setIdModelo(resultSet.getInt("ID_MODELO"));
            modelo.setNome(resultSet.getString("Nome"));
            modelo.setUrl(resultSet.getString("Imagem"));

            // Aqui você pode definir a marca do modelo se ela estiver disponível no ResultSet
            // modelo.setIdMarca(resultSet.getInt("ID_MARCA"));

            return modelo;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    return null;
}

}
