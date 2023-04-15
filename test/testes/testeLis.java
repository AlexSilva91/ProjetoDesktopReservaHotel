/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import main.java.DAO.ClienteDao;
import main.java.DAO.ReservaDao;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class testeLis {

    public static void main(String[] args) {
        ReservaDao dao = new ReservaDao();
        ClienteDao cd = new ClienteDao();
        Reserva r = dao.ConReserv(12);
        System.out.println("\nData Inicial: "+r.getHoraEntrada());
    }
}
