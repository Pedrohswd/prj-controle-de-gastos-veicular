/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Modelo;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public interface IModeloController {

    public void criarModelo(Modelo modelo);

    public void deletarModelo(Modelo modelo);

    public void alterarModelo(Modelo modelo);

    public ResultSet carregTabela(String table);
}
