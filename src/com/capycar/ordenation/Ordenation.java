/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.capycar.ordenation;

import com.capycar.model.Lancamento;
import com.capycar.model.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Ordenation {

    public Ordenation() {
    }

    public static ArrayList<Lancamento> quickSortByVeiculo(ArrayList<Lancamento> lancamentos, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(lancamentos, low, high);

            quickSortByVeiculo(lancamentos, low, pivotIndex - 1);
            quickSortByVeiculo(lancamentos, pivotIndex + 1, high);
        }

        return lancamentos;
    }

    public static int partition(ArrayList<Lancamento> lancamentos, int low, int high) {
        int pivot = lancamentos.get(high).getVeiculo().getIdVeiculo();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lancamentos.get(j).getVeiculo().getIdVeiculo() < pivot) {
                i++;
                swap(lancamentos, i, j);
            }
        }

        swap(lancamentos, i + 1, high);
        return i + 1;
    }

    public static void swap(ArrayList<Lancamento> lancamentos, int i, int j) {
        Lancamento temp = lancamentos.get(i);
        lancamentos.set(i, lancamentos.get(j));
        lancamentos.set(j, temp);
    }
}
