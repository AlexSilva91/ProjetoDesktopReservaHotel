package test.testes;

import main.java.Controller.ClienteController;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class TesteCliente {

	public static void main(String[] args) {
		Cliente cliente;
		ClienteDao clienteDao = new ClienteDao();
		cliente = new Cliente(12, "Joana", "joana9164@gmail.com", "981469865");
		ClienteController controller = new ClienteController();
		controller.CadastrarCliente(cliente);

	}

}
