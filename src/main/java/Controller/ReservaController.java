/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import javax.swing.JOptionPane;
import main.java.DAO.ReservaDao;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class ReservaController {

    private static Reserva reserva = new Reserva();
    private static final ReservaDao DAO = new ReservaDao();

    public void CadastrarReserva(Reserva r) {
        try {
            DAO.SaveReserva(r);
            JOptionPane.showMessageDialog(null, "Dados Cadastrados!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro! Dados inválidos!\n" + e.getMessage());
        }
    }

    public Reserva Consulta(int cpf) {
        return reserva = this.DAO.findById(cpf);
    }
}
