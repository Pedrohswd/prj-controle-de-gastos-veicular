/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Proprietario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProprietarioDao implements IProprietarioDao {
    
    private java.sql.Connection conexao = null;
    
    public ProprietarioDao(){
        conexao = GastoRiderAPI.conectBD();
    }

    @Override
    public void incluirProprietario(Proprietario proprietario) {
        try {
            String sql = "INSERT INTO Proprietario (CPF_CNPJ, Nome, Email, Telefone, CategoriaCNH, DataNasc_Criacao, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, Estado)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, proprietario.getCPF_CNPJ());
            preparedStatement.setString(2, proprietario.getNome());
            preparedStatement.setString(3, proprietario.getEmail());
            preparedStatement.setString(4, proprietario.getTelefone());
            preparedStatement.setString(5, proprietario.getCategoriaCNH());
            preparedStatement.setString(6, proprietario.getDataNasCria().toString());
            preparedStatement.setString(7, proprietario.getCEP());
            preparedStatement.setString(8, proprietario.getLogradouro());
            preparedStatement.setString(9, proprietario.getNumero());
            preparedStatement.setString(10, proprietario.getComplemento());
            preparedStatement.setString(11, proprietario.getBairro());
            preparedStatement.setString(12, proprietario.getCidade());
            preparedStatement.setString(13, proprietario.getEstado());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    @Override
    public void alterarProprietario(Proprietario proprietario) {
        try {
            String sql = "UPDATE Proprietário SET Nome = ?, Email = ?, Telefone = ?, CategoriaCNH = ?, DataNascimento = ?, CEP = ?, Logradouro = ?, Numero = ?, Complemento = ?, Bairro = ?"
                    + ", Cidade = ?, Estado = ? WHERE CPF_CNPJ = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, proprietario.getNome());
            preparedStatement.setString(2, proprietario.getEmail());
            preparedStatement.setString(3, proprietario.getTelefone());
            preparedStatement.setString(4, proprietario.getCategoriaCNH());
            preparedStatement.setString(5, proprietario.getDataNasCria().toString());
            preparedStatement.setString(6, proprietario.getCEP());
            preparedStatement.setString(7, proprietario.getLogradouro());
            preparedStatement.setString(8, proprietario.getNumero());
            preparedStatement.setString(9, proprietario.getComplemento());
            preparedStatement.setString(10, proprietario.getBairro());
            preparedStatement.setString(11, proprietario.getCidade());
            preparedStatement.setString(12, proprietario.getEstado());
            preparedStatement.setString(13, proprietario.getCPF_CNPJ());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

}
