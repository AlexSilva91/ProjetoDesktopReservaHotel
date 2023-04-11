/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class TesteAtualizaCliente {

    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getConnection();
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        Reserva reserva = new Reserva();

        try {
            cliente = clienteDao.findById(679);
            em.detach(cliente);
            reserva.setDataInicial(LocalDate.now());
            reserva.setHoraEntrada(LocalTime.now());
            reserva.setStatus("aprovada");
            reserva.setValorTotalDiaria(40);
            reserva.setValorDiaria(40);
            reserva.setCliente(cliente);
            cliente.setReserva(reserva);
            clienteDao.AtualizaCliente(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}