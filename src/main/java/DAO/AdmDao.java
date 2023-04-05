/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.DAO;

import javax.persistence.EntityManager;
import main.java.ConnectionFactory.ConnectionFactory;
import main.java.model.Adm;

/**
 *
 * @author HP - 4300
 */
public class AdmDao {

    private final EntityManager em = ConnectionFactory.getConnection();

    public void SaveUser(Adm adm) {

        this.em.getTransaction().begin();
        this.em.persist(adm);
        this.em.getTransaction().commit();
        this.em.getTransaction().rollback();
        this.em.close();

    }

    /*    public List<Cliente> ConsultCliente(int id) {
        String jpql = "select c from Cliente as c where c.id =:id";
        Query q;
        List<Cliente> list;
        q = em.createQuery(jpql, Reserva.class);
        q.setParameter("id", id);
        return list = q.getResultList();

    }*/
    public Adm findById(int id) {
        return this.em.find(Adm.class, id);
    }

    public void removeCliente(int adm_id) {
        Adm adm = this.em.getReference(Adm.class, adm_id);
        this.em.getTransaction().begin();
        adm = this.em.merge(adm);
        this.em.remove(adm);
        this.em.getTransaction().commit();
    }

    public void AtualizaCliente(Adm adm) {
        this.em.getTransaction().begin();
        this.em.merge(adm);
        this.em.getTransaction().commit();

    }
}
