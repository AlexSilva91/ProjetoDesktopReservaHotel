package test.testes;

import main.java.Controller.ClienteController;
import main.java.model.Cliente;
import main.java.resources.relatorio.RelatorioCliente;

/**
 *
 * @author HP - 4300
 */
public class testeRelatorio {

	public static void main(String[] args) {
		ClienteController cc = new ClienteController();
		Cliente c = cc.Consulta(12);
		RelatorioCliente rc = new RelatorioCliente(c);
		rc.gerarCabecalho();
		rc.gerarCorpo();
		rc.gerarRodape();
		rc.imprimir();
	}
}
