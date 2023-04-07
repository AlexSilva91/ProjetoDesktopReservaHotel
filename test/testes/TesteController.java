/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.time.LocalDate;
import java.time.LocalTime;
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
        try {
            cliente = clienteController.Consulta(679);
            reserva.setDataInicial(LocalDate.now());
            reserva.setHoraEntrada(LocalTime.now());
            reserva.setStatus("aprovada");
            reserva.setDuracao("5 Dias");
            reserva.setValorTotalDiaria(40);
            reserva.setValorDiaria(40);
            reserva.setCliente(cliente);
            cliente.setReserva(reserva);
            clienteController.ClienteReserva(cliente.getCpf(), reserva);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
