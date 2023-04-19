/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.List;
import main.java.Controller.ReservaController;
import main.java.model.Cliente;
import main.java.model.Reserva;
import main.java.resources.relatorio.RelatorioPDF;

/**
 *
 * @author HP - 4300
 */
public class TesteRelatorio {

    public static void main(String[] args) {
        ReservaController controller = new ReservaController();
        Cliente cliente = new Cliente(123, "Alex", "alexalves9164@gmail.com", "1221");

        List<Reserva> rs = controller.listAll(123);

        RelatorioPDF dF = new RelatorioPDF(cliente, "ret.pdf");
        dF.gerarCabecalho();
        dF.gerarCorpo(rs);
        dF.gerarRodape();
        dF.imprimir();
        for (Reserva r : rs) {
            System.out.println("\n");
            System.out.println(r.getDataInicial());
            System.out.println(r.getDataFinal());
            System.out.println(r.getHoraEntrada());
            System.out.println(r.getQuarto());
            System.out.println(r.getStatus());
            System.out.println(r.getValorDiaria());
        }
    }
}
