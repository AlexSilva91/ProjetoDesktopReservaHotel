package test.testes;

import javax.persistence.EntityManager;

import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ClienteDao;
import main.java.model.Cliente;
import main.java.model.Reserva;

/**
 *
 * @author HP - 4300
 */
public class TesteAtualizaCliente {

	public static void main(String[] args) {
		EntityManager em = ConnectionFactory.getConnection();
		Cliente cliente = new Cliente();
		ClienteDao clienteDao = new ClienteDao();
		Reserva reserva = new Reserva();

		try {
			cliente = clienteDao.findById(123);
			// em.detach(cliente);
			cliente.setNome("Alex da S");
			clienteDao.AtualizaCliente(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}