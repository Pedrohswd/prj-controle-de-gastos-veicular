/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Proprietario;
import com.capycar.persistence.ProprietarioDao;

/**
 *
 * @author pedro
 */
public class ProprietarioController implements IPropretarioController{
    
    ProprietarioDao proprietarioDao = new ProprietarioDao();

    @Override
    public void incluirProprietario(Proprietario proprietario) {
        proprietarioDao.incluirProprietario(proprietario);
    }

    @Override
    public void alterarProprietario(Proprietario proprietario) {
        proprietarioDao.alterarProprietario(proprietario);
    }
    
}
