/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Marca;
import com.capycar.persistence.MarcaDao;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public class MarcaController implements IMarcaController{
    
    MarcaDao marcaDao = new MarcaDao();

    @Override
    public void criarMarca(Marca marca) {
        marcaDao.criarMarca(marca);
    }

    @Override
    public void deletarMarca(Marca marca) {
        marcaDao.deletarMarca(marca);
    }

    @Override
    public void alterarMarca(Marca marca) {
        marcaDao.alterarMarca(marca);
    }

    @Override
    public ResultSet carregTabela() {
        return marcaDao.carregTabela();
    }
    
}
