/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Categoria;
import java.sql.ResultSet;

/**
 *
 * @author educa
 */
public interface ICategoriaController {
    
    public void incluirCategoria(Categoria categoria);
    
    public void alterarCategoria(Categoria categoria);
    
    public void excluirCategoria(Categoria categoria);
    
    public ResultSet carregTabela(String tabela);
    
}
