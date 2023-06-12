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
    private String tipo;
    private String categoria_pai;

    public Categoria() {
    }

    public Categoria(int id_categoria, String descricao, String tipo, String categoria_pai) {
        this.id_categoria = id_categoria;
        this.descricao = descricao;
        this.tipo = tipo;
        this.categoria_pai = categoria_pai;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria() {
        this.id_categoria = id_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria_pai;
    }

    public void setCategoria(String categoria) {
        this.categoria_pai = categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + "descricao=" + descricao + ", tipo=" + tipo + ", categoria=" + categoria_pai + '}';
    }

}
