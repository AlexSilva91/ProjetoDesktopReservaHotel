package test.teste;

import java.util.List;

import main.java.Controller.ClienteController;
import main.java.Controller.ReservaController;
import main.java.model.Cliente;
import main.java.model.Reserva;
import main.java.resources.relatorio.RelatorioReserva;

/**
 *
 * @author HP - 4300
 */
public class TesteRelatorio {

	public static void main(String[] args) {
		ReservaController controller = new ReservaController();
		ClienteController cc = new ClienteController();
		Cliente cliente = cc.Consulta(123);

		List<Reserva> rs = controller.listAll(123);

		RelatorioReserva dF = new RelatorioReserva(cliente, "relatorio.pdf");
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
		System.out.println(cliente.getNome());
	}
}
