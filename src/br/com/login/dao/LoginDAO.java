package br.com.login.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class LoginDAO {

    private Connection connection;

    public LoginDAO() {
        // Configurar a conexão com o banco de dados
        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream("src/DB/CFG_DB.txt");
            props.load(in);
            in.close();

            String url = props.getProperty("url"); // Obtém a URL de conexão a partir do arquivo de propriedades
            String user = props.getProperty("usuario"); // Obtém o nome de usuário do banco de dados a partir do arquivo de propriedades
            String password = props.getProperty("senha"); // Obtém a senha do banco de dados a partir do arquivo de propriedades

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão com o banco de dados estabelecida!");
        } catch (Exception e) {
            System.out.println("Falha na conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /*public void cadastrarUsuario( String Email, String NomeCompleto, String Senha) throws SQLException{
       String sql = "INSERT INTO Usuario (email, nomecompleto, senha) VALUES( ' "+Email+" ' , ' "+NomeCompleto+" ' ,' "+Senha+" ')";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.execute();
         connection.close(); */
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
