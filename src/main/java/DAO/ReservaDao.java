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

    public List<Reserva> ConsultaReserva(int id) {
        String jpql = "select r from Reserva as r where r.id =:id";
        Query q = null;
        List<Reserva> list;
        q = em.createQuery(jpql, Reserva.class);
        q.setParameter("id", id);
        return list = q.getResultList();
    }
    public Reserva findById(int id){
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
