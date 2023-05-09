package test.teste;

import main.java.Controller.LoginController;
import main.java.model.Adm;
import main.java.model.Cliente;
import main.java.model.UsuarioAbstrato;

/**
 *
 * @author HP - 4300
 */
public class testeLogin2 {

	public static void main(String[] args) {
		int cpf = 123;
		LoginController loginController = new LoginController();
		UsuarioAbstrato abstrato;
		try {
			abstrato = loginController.checaInstancia(cpf);
			System.out.println("\nNome: " + abstrato.getNome());
			if (abstrato instanceof Cliente) {
				System.out.println("Cliente");
			}
			if (abstrato instanceof Adm) {
				System.out.println("Adm");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
