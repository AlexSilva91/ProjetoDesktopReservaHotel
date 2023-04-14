/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import main.java.Controller.ClienteController;
import main.java.model.Cliente;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class TesteController {

    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        Reserva reserva = new Reserva();
        Cliente cliente = new Cliente();
        String dataIni = "07/02/2025";
        String dataFini = "07/02/2026";
        String hora = "20:30";
        try {
            
            reserva.setStatus("pendente");
            reserva.setValorDiaria(40);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
