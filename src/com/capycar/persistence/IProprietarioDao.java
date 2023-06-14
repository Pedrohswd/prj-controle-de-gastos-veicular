/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.model.Proprietario;

/**
 *
 * @author pedro
 */
public interface IProprietarioDao {

    public void incluirProprietario(Proprietario propietario);

    public void alterarProprietario(Proprietario proprietario);
    
    public Proprietario consultarProprietario(String tabela);
}
