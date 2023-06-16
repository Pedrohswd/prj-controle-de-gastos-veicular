/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Subcategoria;
import com.capycar.persistence.SubcategoriaDAO;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class SubcategoriaController implements ISubcategoriaController {

    SubcategoriaDAO subcategoriaDAO = new SubcategoriaDAO();

    @Override
    public void incluirSubcategoria(Subcategoria subcategoria) {
        subcategoriaDAO.incluirSubcategoria(subcategoria);
    }

    @Override
    public void alterarSubcategoria(Subcategoria subcategoria) {
        subcategoriaDAO.alterarSubcategoria(subcategoria);
    }

    @Override
    public void excluirSubcategoria(Subcategoria subcategoria) {
        subcategoriaDAO.excluirSubcategoria(subcategoria);
    }

    @Override
    public ResultSet carregTabela(String tabela) {
        return subcategoriaDAO.carregTabela(tabela);
    }

}
