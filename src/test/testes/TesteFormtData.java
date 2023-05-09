package test.testes;

import java.time.LocalDate;

import main.java.resources.conversor.Conversor;

/**
 *
 * @author HP - 4300
 */
public class TesteFormtData {
	public static void main(String[] args) {

		String data = "2023/03/27";
		new Conversor();
		LocalDate cd = Conversor.ConversorData(data);
		System.out.println(cd);

	}
}
