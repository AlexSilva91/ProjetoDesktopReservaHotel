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
        try {
            this.em.persist(adm);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        this.em.close();

    }
   public Adm findById(int id) {
        return this.em.find(Adm.class, id);
    }

}
