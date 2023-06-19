/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capycar.persistence;

import com.capycar.model.Categoria;
import com.capycar.model.Subcategoria;
import com.capycar.model.Veiculo;
import java.util.Date;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author educa
 */
public interface IRelatorioGraficoDAO {
    public ChartPanel gerarGrafico(Veiculo veiculo, Categoria categoria, Subcategoria subcategoria, Date dataInicio, Date dataFim);
}
