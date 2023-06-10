/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Proprietario;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ProprietarioDao implements IProprietarioDao {

    private java.sql.Connection connection = null;

    public ProprietarioDao() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void incluirProprietario(Proprietario proprietario) {
        try {
            Date date = new Date(proprietario.getDataNasCria().getTime());
            String sql = "INSERT INTO Proprietario (CPF_CNPJ, Nome, Email, Telefone, CategoriaCNH, DataNasc_Criacao, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, Estado, Tipo_pessoa)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, proprietario.getCPF_CNPJ());
            preparedStatement.setString(2, proprietario.getNome());
            preparedStatement.setString(3, proprietario.getEmail());
            preparedStatement.setString(4, proprietario.getTelefone());
            preparedStatement.setString(5, proprietario.getCategoriaCNH());
            preparedStatement.setDate(6, date);
            preparedStatement.setString(7, proprietario.getCEP());
            preparedStatement.setString(8, proprietario.getLogradouro());
            preparedStatement.setString(9, proprietario.getNumero());
            preparedStatement.setString(10, proprietario.getComplemento());
            preparedStatement.setString(11, proprietario.getBairro());
            preparedStatement.setString(12, proprietario.getCidade());
            preparedStatement.setString(13, proprietario.getEstado());
            preparedStatement.setString(14, proprietario.getTipoPessoa());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void alterarProprietario(Proprietario proprietario) {
        try {
            Date date = new Date(proprietario.getDataNasCria().getTime());
            String sql = "UPDATE Proprietario SET Nome = ?, Email = ?, Telefone = ?, CategoriaCNH = ?, DataNasc_Criacao = ?, CEP = ?, Logradouro = ?, Numero = ?, Complemento = ?, Bairro = ?"
                    + ", Cidade = ?, Estado = ?, Tipo_pessoa = ? WHERE CPF_CNPJ = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, proprietario.getNome());
            preparedStatement.setString(2, proprietario.getEmail());
            preparedStatement.setString(3, proprietario.getTelefone());
            preparedStatement.setString(4, proprietario.getCategoriaCNH());
            preparedStatement.setDate(5, date);
            preparedStatement.setString(6, proprietario.getCEP());
            preparedStatement.setString(7, proprietario.getLogradouro());
            preparedStatement.setString(8, proprietario.getNumero());
            preparedStatement.setString(9, proprietario.getComplemento());
            preparedStatement.setString(10, proprietario.getBairro());
            preparedStatement.setString(11, proprietario.getCidade());
            preparedStatement.setString(12, proprietario.getEstado());
            preparedStatement.setString(13, proprietario.getTipoPessoa());
            preparedStatement.setString(14, proprietario.getCPF_CNPJ());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public String recuperarChavePrimaria(String tabela) {
        String dado = null;

        try {
            // Preparar a consulta SQL
            String sql = "SELECT * FROM " + tabela + " LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Executar a consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificar se há um dado na tabela
            if (resultSet.next()) {
                dado = resultSet.getString(1); // Supondo que o dado a ser recuperado esteja na primeira coluna da tabela
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dado;
    }

    @Override
    public Proprietario consultarProprietario(String tabela) {
        Proprietario proprietario = null;
        String idProprietario = recuperarChavePrimaria(tabela);

        try {
            // Preparar a consulta SQL
            String sql = "SELECT * FROM proprietario WHERE CPF_CNPJ = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idProprietario);

            // Executar a consulta
            ResultSet resultSet = statement.executeQuery();

            // Verificar se há um proprietário com o ID informado
            if (resultSet.next()) {
                // Extrair os dados do resultSet CPF_CNPJ, Nome, Email, Telefone, CategoriaCNH, DataNasc_Criacao, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, Estado
                String id = resultSet.getString("CPF_CNPJ");
                String nome = resultSet.getString("Nome");
                String email = resultSet.getString("Email");
                String telefone = resultSet.getString("Telefone");
                String categoriaCNH = resultSet.getString("Telefone");
                Date data = resultSet.getDate("DataNasc_Criacao");
                String cEP = resultSet.getString("CEP");
                String logradouro = resultSet.getString("Logradouro");
                String numero = resultSet.getString("Numero");
                String complemento = resultSet.getString("Complemento");
                String bairro = resultSet.getString("Bairro");
                String cidade = resultSet.getString("Cidade");
                String estado = resultSet.getString("Estado");
                String tipoPessoa = resultSet.getString("Tipo_pessoa");
                proprietario = new Proprietario(id, nome, email, telefone, categoriaCNH, data, cEP, logradouro, numero, bairro, cidade, estado, complemento, tipoPessoa);
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proprietario;
    }
}
