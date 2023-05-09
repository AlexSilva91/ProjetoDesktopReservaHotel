/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.relatorio;

import java.util.List;

import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public interface Relatorios {
	public void gerarCabecalho();

	public void gerarCorpo(List<Reserva> r);

	public void gerarRodape();

	public void imprimir();
}
