/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.persistence;

/**
 *
 * @author aluno
 */

import com.capycar.model.Subcategoria;
import java.sql.ResultSet;

public interface ISubcategoriaDAO {

    public void incluirSubcategoria(Subcategoria subcategoria);

    public void alterarSubcategoria(Subcategoria subcategoria);

    public void excluirSubcategoria(Subcategoria subcategoria);

    public ResultSet carregTabela(String tabela);

}
