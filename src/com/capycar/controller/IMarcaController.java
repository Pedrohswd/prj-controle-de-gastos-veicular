/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Marca;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public interface IMarcaController {

    public void criarMarca(Marca marca);

    public void deletarMarca(Marca marca);

    public void alterarMarca(Marca marca);

    public ResultSet carregTabela();
}
