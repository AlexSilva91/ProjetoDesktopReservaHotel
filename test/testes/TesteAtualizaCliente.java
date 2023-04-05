/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class TesteAtualizaCliente {

    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getConnection();
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        try{
            cliente = clienteDao.findById(123);
            em.detach(cliente);
            cliente.setNome("AlexSilva");
            clienteDao.AtualizaCliente(cliente);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
