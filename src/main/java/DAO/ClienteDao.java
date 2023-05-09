/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import main.java.ConnectionFactory.ConnectionFactory;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class ClienteDao {

	private final EntityManager em = ConnectionFactory.getConnection();

	public void SaveCliente(Cliente cliente) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(cliente);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.getMessage();
		}

	}

	public ArrayList<Cliente> ConsultCliente() {
		String jpql = "from Cliente c";
		Query q = em.createQuery(jpql, Cliente.class);
		ArrayList<Cliente> list = (ArrayList<Cliente>) q.getResultList();
		return list;
	}

	public Cliente findById(int id) {
		return this.em.find(Cliente.class, id);
	}

	public void removeCliente(int cliente_id) {
		Cliente cliente = this.em.getReference(Cliente.class, cliente_id);
		this.em.getTransaction().begin();
		cliente = this.em.merge(cliente);
		this.em.remove(cliente);
		this.em.getTransaction().commit();
	}

	public void AtualizaCliente(Cliente cliente) {
		this.em.getTransaction().begin();
		this.em.merge(cliente);
		this.em.getTransaction().commit();

	}
}
