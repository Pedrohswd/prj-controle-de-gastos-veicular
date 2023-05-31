package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LoginDAO {

    private Connection connection;
    GastoRiderAPI connectionBD = new GastoRiderAPI();

    public LoginDAO() {
            connection = connectionBD.conectBD();
            System.out.println("Conexão com o banco de dados estabelecida!");
    }

    public boolean login(String Email, String Senha) throws SQLException {
        String sql = "SELECT email, senha FROM Usuario WHERE email = ? AND senha = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Email);
            statement.setString(2, Senha);
            ResultSet resultSet = statement.executeQuery();

            // Verificar se há um usuário no resultado da consulta
            if (resultSet.next()) {
                String emailRetornado = resultSet.getString("email");
                String senhaRetornada = resultSet.getString("senha");
                System.out.println("Usuário encontrado!");

                // Faça o que for necessário com os dados retornados
                return true;
            } else {
                System.out.println("Usuário não encontrado!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar o login: " + e.getMessage());
            throw e;
        }
    }

    public void cadastrarUsuario(String Email, String NomeCompleto, String Senha) throws SQLException {
        String sql = "INSERT INTO Usuario (email, nomecompleto, senha) VALUES (?, ?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Email);
            statement.setString(2, NomeCompleto);
            statement.setString(3, Senha);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o usuário: " + e.getMessage());
            throw e;
        }
    }
}