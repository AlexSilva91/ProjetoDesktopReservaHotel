package test.testes;

import javax.persistence.EntityNotFoundException;

import main.java.DAO.ClienteDao;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class TesteRemoveReserva {

	public static void main(String[] args) {
		ClienteDao cd = new ClienteDao();
		Cliente c;
		try {
			cd.removeCliente(12);
			System.out.println("\nPronto!");
		} catch (EntityNotFoundException e) {
			System.out.println("Usuário não existe!");
		}
	}

}
