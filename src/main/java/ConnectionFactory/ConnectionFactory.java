/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.ConnectionFactory;

import javax.persistence.*;

/**
 *
 * @author HP - 4300
 */
public class ConnectionFactory {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("hospedagemPU");

    public static EntityManager getConnection() {
        return emf.createEntityManager();
    }

}
