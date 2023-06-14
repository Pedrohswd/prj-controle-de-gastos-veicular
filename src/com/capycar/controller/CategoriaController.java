/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Categoria;
import com.capycar.persistence.CategoriaDAO;
import java.sql.ResultSet;

/**
 *
 * @author educa
 */
public class CategoriaController implements ICategoriaController{
       CategoriaDAO categoriaDAO = new CategoriaDAO();
       
       @Override
       public void incluirCategoria(Categoria categoria){
           categoriaDAO.incluirCategoria(categoria);
       }

    @Override
    public void alterarCategoria(Categoria categoria) {
        categoriaDAO.alterarCategoria(categoria);
    }

    @Override
    public void excluirCategoria(Categoria categoria) {
        categoriaDAO.excluirCategoria(categoria);
    }
    
    public ResultSet carregTabela(String table){
        return categoriaDAO.carregTabela(table);
    }

}
