/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import main.java.Controller.LoginController;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class testeLogin {

    public static void main(String[] args) {
        Cliente c = new Cliente();
        String email = "alexalves9164@gmail.com";
        int cpf = 1234;
        LoginController loginController = new LoginController();
        try {
            System.out.println(loginController.checkLogin(email, cpf));
            System.out.println(loginController.Consulta(cpf).getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        /*ClienteDao cd = new ClienteDao();
        List<Cliente> cl = cd.ConsultCliente(1234);
        for(Cliente c: cl){
            System.out.println(c.getNome());
            System.out.println(c.getCpf());
            System.out.println(c.getEmail());
            System.out.println(c.getTelefone());
        }}

        Cliente c = new Cliente();
        ClienteDao cd = new ClienteDao();
        c = cd.findById(1234);
        System.out.println(c.getNome());
        System.out.println(c.getCpf());
        System.out.println(c.getEmail());
        System.out.println(c.getTelefone());*/
    }
}
