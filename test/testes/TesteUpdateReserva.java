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
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class TesteUpdateReserva {

    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getConnection();
        ReservaDao reservaDao = new ReservaDao();
        Reserva reservaD = new Reserva();
        try {
            /*Efetua uma busca por id e desanexa
              altera os dados que vai ser atualizado
              e anexa novamente pra só então comitar
             */
            reservaD = reservaDao.findById(1);
            em.detach(reservaD);
            reservaD.setValorDiaria(10);
            reservaDao.AtualizaStatus(reservaD);
            /*resM = em.merge(reservaD);*/
        } catch (PersistenceException e) {
            System.out.println(e);
        }
    }
}
