/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.model;

/**
 *
 * @author pedro
 */
public class Modelo {
    
    private int idModelo;
    private String nome;
    private String url;
    private Marca idMarca;

    public Modelo() {
    }

    public Modelo(int idModelo, String nome, String url, Marca idMarca) {
        this.idModelo = idModelo;
        this.nome = nome;
        this.url = url;
        this.idMarca = idMarca;
    }

    public Modelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
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

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
