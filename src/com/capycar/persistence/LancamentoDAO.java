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

/**
 *
 * @author pedro
 */
public class LancamentoDAO implements ILancamentoDAO{
    
    private java.sql.Connection connection = null;
    
    public LancamentoDAO(){
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void criarLancamento(Lancamento lancamento) {
        
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
