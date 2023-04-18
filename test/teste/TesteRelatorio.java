/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import main.java.model.Cliente;
import main.java.resources.relatorio.RelatorioPDF;

/**
 *
 * @author HP - 4300
 */
public class TesteRelatorio {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(123,"Alex Da Silva Alves", "Alex@gmail.com", "1221");
        RelatorioPDF dF = new RelatorioPDF(cliente);
        dF.gerarCabecalho();
        dF.imprimir();
    }
}
