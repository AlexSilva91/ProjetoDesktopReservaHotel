/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author HP - 4300
 */
@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private LocalDate dataInicial;
	@Column
	private LocalDate dataFinal;
	@Column
	private LocalTime horaEntrada;
	@Column
	private String status;
	@Column
	private double valorDiaria;
	@Column
	private int quarto;
	@Column
	private int cpf_cliente;

	public Reserva() {
	}

	public Reserva(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaEntrada, String status, int quarto,
			int cpf) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.horaEntrada = horaEntrada;
		this.status = status;
		this.quarto = quarto;
		this.cpf_cliente = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public int getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(int cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	
}
