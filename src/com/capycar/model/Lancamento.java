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

    private int idLancamento;
    private Veiculo veiculo;
    private Categoria categoria;
    private Subcategoria subCategoria;
    private float valor;
    private Date dataRegistro;

    public Lancamento() {
    }

    public Lancamento(int idLancamento, Veiculo veiculo, Categoria categoria, Subcategoria subCategoria, float valor, Date dataRegistro) {
        this.idLancamento = idLancamento;
        this.veiculo = veiculo;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }

    public int getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
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

    public Subcategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Subcategoria subCategoria) {
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

    @Override
    public String toString() {
        return "Lancamento{" + "idLancamento=" + idLancamento + ", veiculo=" + veiculo + ", categoria=" + categoria + ", subCategoria=" + subCategoria + ", valor=" + valor + ", dataRegistro=" + dataRegistro + '}';
    }

}
