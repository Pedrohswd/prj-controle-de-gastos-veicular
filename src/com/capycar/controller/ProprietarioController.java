/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Proprietario;
import com.capycar.persistence.ProprietarioDao;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class ProprietarioController implements IPropretarioController {

    ProprietarioDao proprietarioDao = new ProprietarioDao();

    @Override
    public void incluirProprietario(Proprietario proprietario) {
        if (validarCPF(proprietario.getCPF_CNPJ()) == true || validarCNPJ(proprietario.getCPF_CNPJ()) == true) {
            proprietarioDao.incluirProprietario(proprietario);
        } else {
            JOptionPane.showMessageDialog(null, "CPF inválido");
        }
    }

    @Override
    public void alterarProprietario(Proprietario proprietario) {
        proprietarioDao.alterarProprietario(proprietario);
    }

    @Override
    public Proprietario consultarProprietario(String tabela) {
        return proprietarioDao.consultarProprietario(tabela);
    }

    private static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais, o que é inválido para um CPF válido
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        // Verifica se os dígitos verificadores calculados são iguais aos informados no CPF
        return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);
    }

    public static boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais, o que é inválido para um CNPJ válido
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = cnpj.charAt(i) - '0';
            soma += digito * peso;
            peso = (peso + 1) % 10;
            if (peso == 1) {
                peso = 2;
            }
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = cnpj.charAt(i) - '0';
            soma += digito * peso;
            peso = (peso + 1) % 10;
            if (peso == 1) {
                peso = 2;
            }
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        // Verifica se os dígitos verificadores calculados são iguais aos informados no CNPJ
        return (cnpj.charAt(12) - '0' == digito1) && (cnpj.charAt(13) - '0' == digito2);
    }

}
