/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.controller;

import br.com.login.dao.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
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

    public void loginUsuario(LoginView view) throws SQLException {
        LoginDAO login = new LoginDAO();
        login.login(view.getjTextFieldLogin().getText(), view.getjPasswordSenhaLogin().getText());

    }

    public void conectarBancoDeDados() {
        // Obter as informações de conexão do arquivo de propriedades
        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream("src/DB/CFG_DB.txt");
            props.load(in);
            in.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo de propriedades: " + e.getMessage());
            return;
        }

        String url = props.getProperty("url"); // obtém a URL de conexão a partir do arquivo de propriedades
        String user = props.getProperty("usuario"); // obtém o nome de usuário do banco de dados a partir do arquivo de propriedades
        String password = props.getProperty("senha"); // obtém a senha do banco de dados a partir do arquivo de propriedades

        // Criar uma instância da classe GastoRiderAPI
        GastoRiderAPI gastoRiderAPI = new GastoRiderAPI();

        // Chamar o método main da classe GastoRiderAPI para estabelecer a conexão
        String[] args = {url, user, password};
        gastoRiderAPI.main(args);
    }
}
