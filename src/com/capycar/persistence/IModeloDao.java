/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.model.Modelo;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public interface IModeloDao {

    public void criarMarca(Modelo modelo);

    public void deletarMarca(Modelo modelo);

    public void alterarMarca(Modelo modelo);

    public ResultSet carregTabela(String table);
}
