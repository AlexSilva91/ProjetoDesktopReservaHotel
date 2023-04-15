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

    private final int MAX = 10;
    private final Random cod = new Random();
    private int codigo = 0;
    private ReservaController controller;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void gerarCodigo() {
        this.codigo = this.cod.nextInt();
    }

    public boolean ValidaCod(int cod) {
        boolean valido = false;
        Reserva reserva;
        try {
            reserva = controller.BuscaQuarto(cod);
            if (cod != reserva.getQuarto() && cod > 0) {
                valido = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valido;
    }
}
