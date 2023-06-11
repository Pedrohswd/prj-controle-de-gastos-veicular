/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.model;

/**
 *
 * @author pedro
 */
public class Marca {

    private int IdMarca;
    private String nome;
    private String url;

    public Marca() {
    }

    public Marca(int IdMarca, String nome, String url) {
        this.IdMarca = IdMarca;
        this.nome = nome;
        this.url = url;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
