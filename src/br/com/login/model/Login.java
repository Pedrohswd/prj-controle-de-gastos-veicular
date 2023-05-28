/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.model;

/**
 *
 * @author felip
 */
public class Login {

    String Email, NomeCompleto, Senha;

    public Login(String Email, String Senha) {
        this.Email = Email;
        this.Senha = Senha;
    }

    public void cadastrar(String Email, String NomeCompleto, String Senha) {
        this.Email = Email;
        this.NomeCompleto = NomeCompleto;
        this.Senha = Senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

}
