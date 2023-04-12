/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.conversor;

import java.util.Random;
import main.java.Controller.ReservaController;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class Gerador {

    private final int MAX = 1000;
    private Reserva r = new Reserva();
    private ReservaController controller = new ReservaController();
    private final Random cod = new Random();
    private int codigo = 0;

    public int gerarCodigo() {
        this.codigo = this.cod.nextInt(MAX);
        return codigo;
    }

    public boolean ValidaCod(int cod) {
        boolean valido = false;
        try {
            r = controller.Consulta(cod);
            if (cod != r.getCod()) {
                valido = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return valido;
    }
}
