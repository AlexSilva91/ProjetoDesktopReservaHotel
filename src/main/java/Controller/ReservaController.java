/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ReservaDao;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class ReservaController {

    private final EntityManager em = ConnectionFactory.getConnection();
    private List<Reserva> listReserva;
    private final ReservaDao reservaDao = new ReservaDao();
    private Reserva reserva = new Reserva();

    public List<Reserva> listAll(int id) {
        try {
            listReserva = reservaDao.Resevas(id);
            if (listReserva != null) {
                return listReserva;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listReserva;
    }

    public void AtualizarReserva(Reserva r) {
        reserva = Busca(r.getId());
        try {
            if (reserva != null) {
                em.detach(reserva);
                reserva = r;
                reservaDao.AtualizaStatus(reserva);
                JOptionPane.showMessageDialog(null, "Reserva atualizada!");
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public Reserva Busca(int id) {
        return reservaDao.findById(id);
    }
    public Reserva BuscaQuarto(int cod){
        try {
            reserva = reservaDao.BuscaQuarto(cod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reserva;
    }
}
