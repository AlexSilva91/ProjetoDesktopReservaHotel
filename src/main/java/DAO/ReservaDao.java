/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import main.java.ConnectionFactory.ConnectionFactory;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class ReservaDao {

	private final EntityManager em = ConnectionFactory.getConnection();

	public void SaveReserva(Reserva reserva) {
		this.em.getTransaction().begin();
		this.em.persist(reserva);
		this.em.getTransaction().commit();
	}

	public List<Reserva> ConsultaReserva() {
		String jpql = "FROM Reserva r";
		Query q = em.createQuery(jpql, Reserva.class);
		List<Reserva> list = q.getResultList();
		return list;
	}

	public Reserva ConReserv(int id) {
		Query q = em.createQuery("SELECT r FROM Reserva as r where r.cpf_cliente =:id", Reserva.class)
				.setParameter("id", id);
		Reserva r = (Reserva) q.getSingleResult();
		return r;
	}

	public Reserva BuscaQuarto(int cod) {
		Query q = em.createQuery("SELECT r FROM Reserva as r where r.quarto =:cod", Reserva.class).setParameter("cod",
				cod);
		Reserva r = (Reserva) q.getSingleResult();
		return r;
	}

	public List<Reserva> Resevas(int id) {
		Query q = em.createQuery("SELECT r FROM Reserva as r where r.cpf_cliente =:id", Reserva.class)
				.setParameter("id", id);
		List<Reserva> r = q.getResultList();
		return r;
	}

	public Reserva findById(int id) {
		return em.find(Reserva.class, id);
	}

	public void removeReserva(int reserva_id) {
		Reserva reserva = this.em.getReference(Reserva.class, reserva_id);
		this.em.getTransaction().begin();
		reserva = this.em.merge(reserva);
		this.em.remove(reserva);
		this.em.getTransaction().commit();
	}

	public void AtualizaStatus(Reserva reserva) {
		this.em.getTransaction().begin();
		this.em.merge(reserva);
		this.em.getTransaction().commit();

	}
}
