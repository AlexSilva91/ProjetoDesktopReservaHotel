/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityNotFoundException;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class TesteRemoveReserva {

    public static void main(String[] args) {
        ClienteDao cd = new ClienteDao();
        Cliente c;
        try {
            c = cd.findById(123);
            System.out.println(c.getNome());
            System.out.println(c.getReserva().getStatus());

        } catch (EntityNotFoundException e) {
            System.out.println("Usuário não existe!");
        }
    }

}
