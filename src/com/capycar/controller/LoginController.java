/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.persistence.LoginDAO;
import com.capycar.view.CadastroView;
import com.capycar.view.LoginView;
import com.capycar.connection.GastoRiderAPI;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author felip
 */
public class LoginController {

    public void cadastroUsuario(CadastroView view) throws SQLException {
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(view.getjTextFieldEmail().getText(), view.getjTextFieldNome().getText(), view.getjPasswordSenha().getText());
    }

    public boolean loginUsuario(LoginView view) throws SQLException {
        LoginDAO login = new LoginDAO();
        if (login.login(view.getjTextFieldLogin().getText(), view.getjPasswordSenhaLogin().getText()) == true) {
            return true;
        }
        return false;
    }
}
