/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import main.java.Controller.ReservaController;
import main.java.resources.conversor.Gerador;

/**
 *
 * @author HP - 4300
 */
public class GeradorTest {

    public static void main(String[] args) {
        Gerador g = new Gerador();
        int n = 0;
        ReservaController controller = new ReservaController();
        for (int i = 0; i < 10; i++) {
            g.gerarCodigo();
            System.out.println(g.getCodigo());
        }
    
    }
}
