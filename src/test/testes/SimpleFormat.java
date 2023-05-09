package test.testes;

import java.time.LocalDate;

import main.java.resources.conversor.Conversor;

/**
 *
 * @author HP - 4300
 */
public class SimpleFormat {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now(); // Data atual
		System.out.println(Conversor.conversorData(localDate));
	}
}
