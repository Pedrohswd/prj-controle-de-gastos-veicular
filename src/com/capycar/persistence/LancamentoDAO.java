/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.connection.GastoRiderAPI;
import com.capycar.controller.LancamentoController;
import com.capycar.model.Categoria;
import com.capycar.model.Lancamento;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import com.capycar.view.LancamentoConsultaView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class LancamentoDAO implements ILancamentoDAO {

    private java.sql.Connection connection = null;

    public LancamentoDAO() {
        connection = GastoRiderAPI.conectBD();
    }

    @Override
    public void criarLancamento(Lancamento lancamento) {

        try {
            Date date = new Date(lancamento.getDataRegistro().getTime());
            String sql = "INSERT INTO Lancamento (ID_VEICULO, ID_CATEGORIA, ID_SUBCATEGORIA, valor, data_lancamento) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lancamento.getVeiculo().getIdVeiculo());
            preparedStatement.setInt(2, lancamento.getCategoria().getidCategoria());
            preparedStatement.setInt(3, lancamento.getSubCategoria().getIdSubcategoria());
            preparedStatement.setFloat(4, lancamento.getValor());
            preparedStatement.setDate(5, date);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lançamento feito com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    @Override
    public void alterarLancamento(Lancamento lancamento) {
        try {
            Date date = new Date(lancamento.getDataRegistro().getTime());
            String sql = "UPDATE Lancamento SET ID_VEICULO = ?, ID_CATEGORIA = ?, ID_SUBCATEGORIA = ?, valor = ?, data_lancamento = ? WHERE ID_LANCAMENTO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lancamento.getVeiculo().getIdVeiculo());
            preparedStatement.setInt(2, lancamento.getCategoria().getidCategoria());
            preparedStatement.setInt(3, lancamento.getSubCategoria().getIdSubcategoria());
            preparedStatement.setFloat(4, lancamento.getValor());
            preparedStatement.setDate(5, date);
            preparedStatement.setInt(6, lancamento.getIdLancamento());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void excluirLancamento(Lancamento lancamento) {
        try {
            String sql = "DELETE FROM Lancamento WHERE ID_LANCAMENTO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, lancamento.getIdLancamento());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria,
            java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_VEICULO = ? AND ID_CATEGORIA = ? AND ID_SUBCATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, veiculo.getIdVeiculo());
            statement.setInt(2, categoria.getidCategoria());
            statement.setInt(3, subcategoria.getIdSubcategoria());
            statement.setDate(4, dateInicio);
            statement.setDate(5, dateFim);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                veiculo = new Veiculo();
                categoria = new Categoria();
                subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Categoria categoria, Subcategoria subcategoria, java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_CATEGORIA = ? AND ID_SUBCATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            preparedStatement.setInt(1, categoria.getidCategoria());
            preparedStatement.setInt(2, subcategoria.getIdSubcategoria());
            preparedStatement.setDate(3, dateInicio);
            preparedStatement.setDate(4, dateFim);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                Veiculo veiculo = new Veiculo();
                categoria = new Categoria();
                subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Subcategoria subcategoria, java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_SUBCATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            preparedStatement.setInt(1, subcategoria.getIdSubcategoria());
            preparedStatement.setDate(2, dateInicio);
            preparedStatement.setDate(3, dateFim);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                Veiculo veiculo = new Veiculo();
                Categoria categoria = new Categoria();
                subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE data_lancamento BETWEEN ? AND ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            preparedStatement.setDate(1, dateInicio);
            preparedStatement.setDate(2, dateFim);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                Veiculo veiculo = new Veiculo();
                Categoria categoria = new Categoria();
                Subcategoria subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_VEICULO = ? AND data_lancamento BETWEEN ? AND ?";
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, veiculo.getIdVeiculo());
            statement.setDate(2, dateInicio);
            statement.setDate(3, dateFim);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                veiculo = new Veiculo();
                Categoria categoria = new Categoria();
                Subcategoria subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Categoria categoria, java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_VEICULO = ? AND ID_CATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, veiculo.getIdVeiculo());
            statement.setInt(2, categoria.getidCategoria());
            statement.setDate(3, dateInicio);
            statement.setDate(4, dateFim);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                veiculo = new Veiculo();
                categoria = new Categoria();
                Subcategoria subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Veiculo veiculo, Subcategoria subcategoria, java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_VEICULO = ? AND ID_SUBCATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, veiculo.getIdVeiculo());
            statement.setInt(2, subcategoria.getIdSubcategoria());
            statement.setDate(3, dateInicio);
            statement.setDate(4, dateFim);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                veiculo = new Veiculo();
                Categoria categoria = new Categoria();
                subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Lancamento> consultarLancamento(Categoria categoria, java.util.Date dataInicio, java.util.Date dataFim) {
        try {
            ArrayList<Lancamento> listLancamento = new ArrayList<>();
            String sql = "SELECT * FROM Lancamento WHERE ID_CATEGORIA = ? AND data_lancamento BETWEEN ? AND ?";
            Date dateInicio = new Date(dataInicio.getTime());
            Date dateFim = new Date(dataFim.getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoria.getidCategoria());
            statement.setDate(2, dateInicio);
            statement.setDate(3, dateFim);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Lancamento lacamento = new Lancamento();
                Veiculo veiculo = new Veiculo();
                categoria = new Categoria();
                Subcategoria subcategoria = new Subcategoria();
                lacamento.setIdLancamento(resultSet.getInt(1));
                ResultSet resultSetAuxiliar = consultarLancamento("Veiculo WHERE id_Veiculo = " + resultSet.getInt(2));
                while (resultSetAuxiliar.next()) {
                    veiculo.setIdVeiculo(resultSetAuxiliar.getInt(1));
                    veiculo.setPlaca(resultSetAuxiliar.getString(2));
                }
                lacamento.setVeiculo(veiculo);
                resultSetAuxiliar = consultarLancamento("Categoria WHERE id_Categoria = " + resultSet.getInt(3));
                while (resultSetAuxiliar.next()) {
                    categoria.setidCategoria(resultSetAuxiliar.getInt(1));
                    categoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setCategoria(categoria);
                resultSetAuxiliar = consultarLancamento("Subcategoria WHERE id_Subcategoria = " + resultSet.getInt(4));
                while (resultSetAuxiliar.next()) {
                    subcategoria.setIdSubcategoria(resultSetAuxiliar.getInt(1));
                    subcategoria.setDescricao(resultSetAuxiliar.getString(2));
                }
                lacamento.setSubCategoria(subcategoria);
                lacamento.setValor(resultSet.getFloat(5));
                lacamento.setDataRegistro(resultSet.getDate(6));
                listLancamento.add(lacamento);
            }
            return listLancamento;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
