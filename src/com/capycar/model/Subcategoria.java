/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.model;

/**
 *
 * @author educa
 */
public class Subcategoria {
    
    private int idSubcategoria;
    private String Descricao;
    private Categoria idCategoria;
    
    public Subcategoria(){
    }
    
    public Subcategoria(int idSubcategoria, String descricao, Categoria idCategoria){
        this.idSubcategoria=idSubcategoria;
        this.Descricao=descricao;
        this.idCategoria=idCategoria;     
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }
    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getDescricao() {
        return Descricao;
    }
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return Descricao;
    }
    
}
