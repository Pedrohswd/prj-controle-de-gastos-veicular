/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Modelo;
import com.capycar.persistence.ModeloDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pedro
 */
public class ModeloController implements IModeloController {

    ModeloDao modeloDao = new ModeloDao();

    @Override
    public void criarModelo(Modelo modelo) {
        modeloDao.criarModelo(modelo);
    }

    @Override
    public void deletarModelo(Modelo modelo) {
        modeloDao.deletarModelo(modelo);
    }

    @Override
    public void alterarModelo(Modelo modelo) {
        modeloDao.alterarModelo(modelo);
    }

    @Override
    public ResultSet carregTabela(String table) {
        return modeloDao.carregTabela(table);
    }
     public boolean verificarVeiculosAssociados(Modelo modelo) throws SQLException  {
        return modeloDao.verificarVeiculosAssociados(modelo);
    }
     
     public List<Modelo> listarModelos() {
    ModeloDao modeloDao = new ModeloDao();
    return modeloDao.listarModelos();
}


}
