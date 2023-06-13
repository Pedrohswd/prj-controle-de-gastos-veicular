/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.model;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Lancamento {
    
    private Veiculo veiculo;
    private Categoria categoria;
    private Categoria subCategoria;
    private float valor;
    private Date dataRegistro;

    public Lancamento() {
    }

    public Lancamento(Veiculo veiculo, Categoria categoria, Categoria subCategoria, float valor, Date dataRegistro) {
        this.veiculo = veiculo;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Categoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    
}
