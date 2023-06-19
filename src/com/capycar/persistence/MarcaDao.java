/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Marca;
import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class MarcaDao implements IMarcaDao {

    private java.sql.Connection connection = null;

    public MarcaDao() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void criarMarca(Marca marca) {
        try {
            String imagePath = marca.getUrl();
            String sql = "INSERT INTO Marca (Nome, Imagem)\n"
                    + "VALUES (?, ?);";
            FileInputStream inputStream = new FileInputStream(new File(imagePath));
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, marca.getNome());
            preparedStatement.setBinaryStream(2, inputStream);
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletarMarca(Marca marca) {
        try {
            String sql = "DELETE FROM Marca WHERE ID_MARCA = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, marca.getIdMarca());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void alterarMarca(Marca marca) {
        try {
            if (marca.getUrl() != null) {
                String sql = "UPDATE Marca SET Nome = ?, Imagem = ? WHERE ID_MARCA = ?";
                String imagePath = marca.getUrl();
                FileInputStream inputStream = new FileInputStream(new File(imagePath));
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, marca.getNome());
                preparedStatement.setBinaryStream(2, inputStream);
                preparedStatement.setInt(3, marca.getIdMarca());
                preparedStatement.executeUpdate();
            } else {
                String sql = "UPDATE Marca SET Nome = ? WHERE ID_MARCA = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, marca.getNome());
                preparedStatement.setInt(2, marca.getIdMarca());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet carregTabela() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Marca");
            ResultSet resultSet;
            return resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Marca buscarMarcaPorId(int idMarca) {
        try {
            String sql = "SELECT * FROM Marca WHERE ID_MARCA = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMarca);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Marca marca = new Marca();
                marca.setIdMarca(resultSet.getInt("ID_MARCA"));
                marca.setNome(resultSet.getString("Nome"));
                marca.setUrl(resultSet.getString("Imagem"));

                return marca;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
       public boolean verificarModelosAssociados(Marca marca) {
        try {
            String sql = "SELECT COUNT(*) FROM Modelo WHERE ID_MARCA = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, marca.getIdMarca());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
}

