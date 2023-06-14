/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;

import com.capycar.model.Veiculo;
import com.capycar.persistence.VeiculoDao;
import java.util.List;

public class VeiculoController implements IVeiculoController {

    private VeiculoDao veiculoDao;

    public VeiculoController(VeiculoDao veiculoDao) {
        this.veiculoDao = veiculoDao;
    }

    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculoDao.cadastrarVeiculo(veiculo);
    }

    @Override
    public void deletarVeiculo(int idVeiculo) {
        veiculoDao.deletarVeiculo(idVeiculo);
    }

    @Override
    public void alterarVeiculo(Veiculo veiculo) {
        veiculoDao.alterarVeiculo(veiculo);
    }

    @Override
    public Veiculo buscarVeiculoPorId(int idVeiculo) {
        return veiculoDao.buscarVeiculoPorId(idVeiculo);
    }

    @Override
    public List<Veiculo> listarVeiculos() {
        return veiculoDao.listarVeiculos();
    }
}
