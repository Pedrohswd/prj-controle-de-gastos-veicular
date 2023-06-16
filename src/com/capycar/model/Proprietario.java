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
public class Proprietario {

    private String CPF_CNPJ;
    private String nome;
    private String email;
    private String telefone;
    private String categoriaCNH;
    private Date dataNasCria;
    private String CEP;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String tipoPessoa;

    public Proprietario() {
    }

    public Proprietario(String CPF_CNPJ, String nome, String email, String telefone, String categoriaCNH, Date dataNasCria, String CEP, String logradouro, String numero, String bairro, String cidade, String estado, String complemento, String tipoPessoa) {
        this.CPF_CNPJ = CPF_CNPJ;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.categoriaCNH = categoriaCNH;
        this.dataNasCria = dataNasCria;
        this.CEP = CEP;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.tipoPessoa = tipoPessoa;
    }

    public Proprietario(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public Date getDataNasCria() {
        return dataNasCria;
    }

    public void setDataNasCria(Date dataNasCria) {
        this.dataNasCria = dataNasCria;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipo_pessoa) {
        this.tipoPessoa = tipo_pessoa;
    }

    @Override
    public String toString() {
        return "Proprietario{" + "CPF_CNPJ=" + CPF_CNPJ + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", categoriaCNH=" + categoriaCNH + ", dataNasCria=" + dataNasCria + ", CEP=" + CEP + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", complemento=" + complemento + ", complemento=" + tipoPessoa +'}';
    }

}
