/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author HP - 4300
 */
@Entity
public class Cliente extends UsuarioAbstrato implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int cpf;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String telefone;

	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente(int cpf, String nome, String email, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente(int cpf, String nome, String email, String telefone, Reserva reserva) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Cliente() {

	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getTelefone() {
		return telefone;
	}

	@Override
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int getCpf() {
		return cpf;
	}

	@Override
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

}
