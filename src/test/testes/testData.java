package test.testes;

import main.java.resources.conversor.Conversor;

/**
 *
 * @author HP - 4300
 */
public class testData {

	public static void main(String[] args) {
		String datainicio = "17/04/2023";
		String dataFim = "20/04/2023";
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;

		if (Conversor.DataInicioMaiorQueAtual(Conversor.ConversorData(datainicio))
				|| Conversor.DataInicioIgualAtual(Conversor.ConversorData(datainicio))) {
			test1 = true;
		}
		if (Conversor.DataInicMenorQueFinal(Conversor.ConversorData(datainicio), Conversor.ConversorData(dataFim))
				|| Conversor.DataInicioIgualFinal(Conversor.ConversorData(datainicio),
						Conversor.ConversorData(dataFim))) {
			test2 = true;
		}
		if (Conversor.DataInicioMenorQueAtual(Conversor.ConversorData(datainicio))) {
			test3 = true;
		}
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(!test3);
		if (test1 && test2 && !test3) {
			System.out.println("Helo world");
		} else {
			System.out.println("Opção inválida!");
		}
	}
}
