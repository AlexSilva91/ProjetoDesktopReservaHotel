/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author HP - 4300
 */
@Entity
public class Adm extends UsuarioAbstrato implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column
	private String nome;
	@Id
	private int cpf;
	@Column
	private String email;

	public Adm() {

	}

	public Adm(int cpf, String nome, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public int getCpf() {
		return cpf;
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
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

}
