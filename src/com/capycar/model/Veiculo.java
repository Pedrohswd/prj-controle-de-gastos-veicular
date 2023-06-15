/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.model;


/**
 *
 * @author pedro
 */
public class Veiculo {

   private int idVeiculo;
    private String placa;
    private String renavam;
    private String anoFabricacao;
    private String anoModelo;
    private String combustivel;
    private float kmAtual;
    private String categoria;
    private Modelo modelo;
    private String status;

    public Veiculo() {
    }

    public Veiculo(int idVeiculo, String placa, String renavam, String anoFabricacao, String anoModelo, Proprietario proprietario, String combustivel, float kmAtual, String categoria, Modelo modelo, String status) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.renavam = renavam;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.combustivel = combustivel;
        this.kmAtual = kmAtual;
        this.categoria = categoria;
        this.modelo = modelo;
        this.status = status;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public float getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(float kmAtual) {
        this.kmAtual = kmAtual;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
