/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.Scanner;
import main.java.Controller.LoginController;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;
import main.java.model.Perfil;

/**
 *
 * @author HP - 4300
 */
public class TestePerfil {

    public static void main(String[] args) {
        int op, op1;
        LoginController lc = new LoginController();
        ClienteDao cd = new ClienteDao();
        Cliente c = new Cliente();
        Scanner tc = new Scanner(System.in);
        do {
            System.out.println("0 - Sair");
            System.out.println("1 - Login");
            op = tc.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    System.out.println("Email :");
                    String email = tc.next();
                    System.out.println("CPF: ");
                    int cpf = tc.nextInt();
                    Perfil.setCpf(cpf);
                    if (lc.checkLogin(email, cpf)) {
                        do {
                            System.out.println("0 - Sair");
                            System.out.println("1 - Exibir CPF");
                            op1 = tc.nextInt();
                            switch (op1) {
                                case 0:
                                    break;
                                case 1:
                                    System.out.println("CPF: "+Perfil.getCpf());
                                    c = cd.findById(Perfil.getCpf());
                                    System.out.println("Nome: "+c.getNome());
                                    System.out.println("Email: "+c.getEmail());
                                    System.out.println("Telefone: "+c.getTelefone());
                                    break;
                            }
                        } while (op1 != 1);

                        break;
                    }
            }

        } while (op != 1);

    }
}
