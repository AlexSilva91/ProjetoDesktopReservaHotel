/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import main.java.Controller.ClienteController;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class TesteCliente {

    public static void main(String[] args) {
        Cliente cliente;
        ClienteDao clienteDao = new ClienteDao();
        cliente = new Cliente(123, "Alex", "alexalves9164@gmail.com", "981469865");
        ClienteController controller = new ClienteController();
        controller.CadastrarCliente(cliente);

    }

}
