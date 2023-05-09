/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ClienteDao;
import main.java.DAO.ReservaDao;
import main.java.View.ClienteView;
import main.java.View.DeletarPerfil;
import main.java.View.EditarPerfil;
import main.java.model.Cliente;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class ClienteController {

	private final EntityManager em = ConnectionFactory.getConnection();
	private final ClienteDao clienteDao = new ClienteDao();
	private final ReservaDao reservaDao = new ReservaDao();
	private static Cliente cliente = new Cliente();
	private final EditarPerfil editarPerfil = new EditarPerfil();
	private final ClienteView clienteView = new ClienteView();
	private final DeletarPerfil deletarPerfil = new DeletarPerfil();
	private static ArrayList<Reserva> r = new ArrayList<Reserva>();
	private static int cpf;

	public void CadastrarCliente(Cliente c) {
		try {
			cliente = this.Consulta(c.getCpf());
			if (cliente == null) {
				clienteDao.SaveCliente(c);
				JOptionPane.showMessageDialog(null, "Dados Cadastrados!");
			} else {
				JOptionPane.showMessageDialog(null, "Cpf já cadastrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro! Dados inválidos!\n" + e.getMessage());
		}
	}

	public void AtualizaClienteReserva(Cliente c) {
		try {
			cliente = this.Consulta(c.getCpf());
			if (cliente != null) {
				em.detach(cliente);
				cliente = c;
				clienteDao.AtualizaCliente(c);
				JOptionPane.showMessageDialog(null, "Reserva Cadastrada!");
			} else {
				JOptionPane.showMessageDialog(null, "Cpf já cadastrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro! Dados inválidos!\n" + e.getMessage());
		}
	}

	public void AtualizaDadosCliente(Cliente c) {
		try {
			cliente = this.Consulta(cpf);
			if (cliente.getCpf() == cpf) {
				em.detach(cliente);
				cliente.setNome(c.getNome());
				cliente.setEmail(c.getEmail());
				cliente.setTelefone(c.getTelefone());
				clienteDao.AtualizaCliente(cliente);
				editarPerfil.ExibeMessageAtualizado();
				clienteView.recebeCliente(cliente);
			}
		} catch (Exception e) {
			editarPerfil.ExibeErro(e);
			System.out.println(e.getCause());
		}

	}

	public Cliente Consulta(int cpf) {
		return cliente = this.clienteDao.findById(cpf);
	}

	public void AtualizaExibicao(int cpf) {
		cliente = Consulta(cpf);
		clienteView.setCliente(cliente);
		clienteView.recebeCPF(cliente);
		System.out.println(cliente.getNome());
	}

	public void deletaCliente(int cpf) {
		cliente = Consulta(cpf);
		Reserva r = reservaDao.ConReserv(cpf);
		try {
			if (r != null) {
				reservaDao.removeReserva(r.getId());
			}
			this.clienteDao.removeCliente(cliente.getCpf());
			this.deletarPerfil.Exibe();
			this.deletarPerfil.fecha();
		} catch (Exception e) {
			this.deletarPerfil.Erro();
		}
	}

	public void deletaClienteList(int cpf) {
		// cliente = Consulta(cpf);
		r = ConsultClienteList(cpf);
		try {
			for (Reserva element : r) {
				if (element != null) {
					reservaDao.removeReserva(element.getId());
				}
				this.clienteDao.removeCliente(cliente.getCpf());
				this.deletarPerfil.Exibe();
				this.deletarPerfil.fecha();
			}

		} catch (Exception e) {
			this.deletarPerfil.Erro();
		}
	}

	public ArrayList<Cliente> ConsultCliente() {
		return clienteDao.ConsultCliente();
	}

	public ArrayList<Reserva> ConsultClienteList(int cpf) {
		return reservaDao.Resevas(cpf);
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		ClienteController.cpf = cpf;
	}

}
