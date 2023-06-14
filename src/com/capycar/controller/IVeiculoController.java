/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capycar.controller;



import com.capycar.model.Veiculo;

import com.capycar.model.Veiculo;
import java.util.List;

 interface IVeiculoController {

    void cadastrarVeiculo(Veiculo veiculo);

    void deletarVeiculo(int idVeiculo);

    void alterarVeiculo(Veiculo veiculo);

    Veiculo buscarVeiculoPorId(int idVeiculo);

    List<Veiculo> listarVeiculos();

}
