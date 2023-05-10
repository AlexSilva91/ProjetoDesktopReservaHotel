/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import main.java.DAO.AdmDao;
import main.java.DAO.ClienteDao;
import main.java.model.Adm;
import main.java.model.Cliente;
import main.java.model.UsuarioAbstrato;

/**
 *
 * @author HP - 4300
 */
public class LoginController {

	private final ClienteDao clientedao = new ClienteDao();
	private final AdmDao admDao = new AdmDao();
	private Cliente cliente = new Cliente();

	public boolean checkLogin(String email, int cpf) {
		UsuarioAbstrato usuarioAbstrato = null;
		try {
			usuarioAbstrato = this.checaInstancia(cpf);
		} catch (Exception e) {
			e.getMessage();
		}
		return usuarioAbstrato.getEmail().equals(email) && usuarioAbstrato.getCpf() == cpf;
	}

	public UsuarioAbstrato checaInstancia(int id) {
		UsuarioAbstrato usuarioAbstratoAdm = admDao.findById(id);
		UsuarioAbstrato usuarioAbstratoCliente = clientedao.findById(id);
		UsuarioAbstrato abstrato = null;
		if (usuarioAbstratoAdm != null) {
			abstrato = usuarioAbstratoAdm;
		}
		if (usuarioAbstratoCliente != null) {
			abstrato = usuarioAbstratoCliente;
		}
		return abstrato;
	}

	public boolean instanceAdm(UsuarioAbstrato usuarioAbstrato) {
		boolean instanceAdm = false;
		if (usuarioAbstrato instanceof Adm) {
			instanceAdm = true;
		}
		return instanceAdm;
	}

	public boolean instanceCliente(UsuarioAbstrato usuarioAbstrato) {
		boolean instanceCliente = false;
		if (usuarioAbstrato instanceof Cliente) {
			instanceCliente = true;
		}
		return instanceCliente;
	}

	public Cliente Consulta(int cpf) {
		cliente = this.clientedao.findById(cpf);
		ClienteController clienteController = new ClienteController();
		clienteController.setCpf(cpf);
		return cliente;
	}

}
