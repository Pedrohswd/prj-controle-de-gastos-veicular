/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.model;

/**
 *
 * @author educa
 */
public class Categoria {

    private int id_categoria;
    private String descricao;

    public Categoria() {
    }

    public Categoria(int id_categoria, String descricao) {
        this.id_categoria = id_categoria;
        this.descricao = descricao;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + "descricao=" + descricao + '}';
    }

}
