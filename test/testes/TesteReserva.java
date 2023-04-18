/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ReservaDao;
import main.java.model.Cliente;
import main.java.model.Reserva;
import main.java.resources.conversor.Conversor;
import main.java.resources.gerador.Gerador;

/**
 *
 * @author HP - 4300
 */
public class TesteReserva {

    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getConnection();
        ReservaDao reservaDao = new ReservaDao();
        Gerador gerador = new Gerador();

        try {
            Reserva reserva = new Reserva();
            reserva.setStatus("Pendente");
            reserva.setDataInicial(Conversor.ConversorData("21/05/2040"));
            reserva.setDataFinal(Conversor.ConversorData("21/06/2040"));
            reserva.setHoraEntrada(Conversor.ConversorHora("14:30"));
            reserva.setValorDiaria(50);
            Cliente cliente = new Cliente();
            cliente = new Cliente(123, "Alex", "alexalves9164@gmail.com", "981469865", reserva);

            reserva.setCliente(cliente);
            reservaDao.SaveReserva(reserva);
        } catch (PersistenceException e) {
            System.out.println("CPF inválido!");
        }

        //        int id = 4;
        //        String jpql = "select r from Reserva as r where r.id =:id";
        //        Query q = null;
        //        List<Reserva> list;
        //        q = em.createQuery(jpql, Reserva.class);
        //        q.setParameter("id", id);
        //        Reserva r = (Reserva) q.getSingleResult();
        //        System.out.println(r.toString());
//        int id = 4;
//        ReservaDao dao = new ReservaDao();
//        List<Reserva> reserva = dao.ConsultaReserva(id);
//        for (Reserva r : reserva) {
//            System.out.println("ID: " + r.getId());
//            System.out.println("Cliente: " + r.getCliente().getNome());
//            System.out.println("CPF: " + r.getCliente().getCpf());
//            System.out.println("Data: " + r.getDataInicial());
//            System.out.println("Hora: " + r.getHoraEntrada());
//            System.out.println("Status: " + r.getStatus());
//            System.out.println("Valor_Dia: " + r.getValorDiaria());
//        }
    }
}
