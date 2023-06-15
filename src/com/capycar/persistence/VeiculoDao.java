/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;
import com.capycar.connection.GastoRiderAPI;
import com.capycar.model.Modelo;
import com.capycar.model.Proprietario;
import com.capycar.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao implements IVeiculoDao {

      private java.sql.Connection connection = null;

    public VeiculoDao() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {
        try {
            String sql = "INSERT INTO Veiculo (Placa, Renavam, Ano_Fabricacao, Ano_Modelo, Combustivel, Km_Atual, Categoria, Id_Modelo, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, veiculo.getPlaca());
            preparedStatement.setString(2, veiculo.getRenavam());
            preparedStatement.setString(3, veiculo.getAnoFabricacao());
            preparedStatement.setString(4, veiculo.getAnoModelo());
            preparedStatement.setString(5, veiculo.getCombustivel());
            preparedStatement.setFloat(6, veiculo.getKmAtual());
            preparedStatement.setString(7, veiculo.getCategoria());
            preparedStatement.setInt(8, veiculo.getModelo().getIdModelo());
            preparedStatement.setString(9, veiculo.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarVeiculo(int idVeiculo) {
        try {
            String sql = "DELETE FROM Veiculo WHERE IdVeiculo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVeiculo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterarVeiculo(Veiculo veiculo) {
        try {
            String sql = "UPDATE Veiculo SET Placa = ?, Renavam = ?, Ano_Fabricacao = ?, Ano_Modelo = ?, Combustivel = ?, Km_Atual = ?, Categoria = ?, Id_Modelo = ?  Status = ? WHERE IdVeiculo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, veiculo.getPlaca());
            preparedStatement.setString(2, veiculo.getRenavam());
            preparedStatement.setString(3, veiculo.getAnoFabricacao());
            preparedStatement.setString(4, veiculo.getAnoModelo());
           preparedStatement.setString(5, veiculo.getCombustivel());
            preparedStatement.setFloat(6, veiculo.getKmAtual());
            preparedStatement.setString(7, veiculo.getCategoria());
            preparedStatement.setInt(8, veiculo.getModelo().getIdModelo());
           preparedStatement.setString(9, veiculo.getStatus());
            preparedStatement.setInt(10, veiculo.getIdVeiculo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Veiculo buscarVeiculoPorId(int idVeiculo) {
        Veiculo veiculo = null;
        try {
            String sql = "SELECT * FROM Veiculo WHERE Id_Veiculo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVeiculo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                veiculo = construirVeiculo(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculo;
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Veiculo";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Veiculo veiculo = construirVeiculo(resultSet);
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    private Veiculo construirVeiculo(ResultSet resultSet) throws SQLException {
        Veiculo veiculo = new Veiculo();
        veiculo.setIdVeiculo(resultSet.getInt("Id_Veiculo"));
        veiculo.setPlaca(resultSet.getString("Placa"));
        veiculo.setRenavam(resultSet.getString("Renavam"));
        veiculo.setAnoFabricacao(resultSet.getString("Ano_Fabricacao"));
        veiculo.setAnoModelo(resultSet.getString("Ano_Modelo"));
        // Recuperar os demais atributos do veículo, como Proprietario e Modelo
        // Utilize os métodos getProprietario() e getModelo() para obter os objetos relacionados
        return veiculo;
    }
}
