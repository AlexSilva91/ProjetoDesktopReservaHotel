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
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class ClienteDao {

    private final EntityManager em = ConnectionFactory.getConnection();
    

    public void SaveUser(Cliente cliente) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(cliente);
            this.em.getTransaction().commit();
            this.em.getTransaction().rollback();
            this.em.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<Cliente> ConsultCliente(int id) {
        String jpql = "select c from Cliente as c where c.id =:id";
        Query q;
        List<Cliente> list;
        q = em.createQuery(jpql, Cliente.class);
        q.setParameter("id", id);
        return list = q.getResultList();
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
