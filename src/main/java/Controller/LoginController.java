/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import main.java.DAO.ClienteDao;
import main.java.View.Login;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class LoginController {

    private final ClienteDao clientedao = new ClienteDao();
    private Cliente cliente = new Cliente();
    private Cliente c = new Cliente();

    public boolean checkLogin(String email, int cpf) {
        try {
            c = this.Consulta(cpf);
        } catch (Exception e) {
            e.getMessage();
        }
        return this.c.getEmail().equals(email) && this.c.getCpf() == cpf;
    }

    public Cliente Consulta(int cpf) {
        cliente = this.clientedao.findById(cpf);
        ClienteController clienteController = new ClienteController();
        clienteController.setCpf(cpf);
        return cliente;
    }

    public void Entrar(Login login) {
        login.Entrar();
    }
}
