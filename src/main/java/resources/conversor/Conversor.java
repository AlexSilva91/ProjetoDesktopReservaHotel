/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.conversor;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HP - 4300
 */
public class Conversor {

	public static LocalDate ConversorData(String data) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(data, format);
		return ld;
	}

	public static LocalTime ConversorHora(String hora) {
		LocalTime time = LocalTime.of(Integer.parseInt(hora.substring(0, 2)), Integer.parseInt(hora.substring(3, 5)));
		return time;
	}

	public static String conversorData(LocalDate date) {
		Date data = Date.valueOf(date);
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatador.format(data);
		return dataFormatada;
	}

	public static boolean DataInicioMaiorQueAtual(LocalDate date) {
		boolean valida = false;
		if (date.isAfter(LocalDate.now())) {
			valida = true;
		}
		return valida;
	}

	public static boolean DataInicioMenorQueAtual(LocalDate date) {
		boolean valida = false;
		if (date.isBefore(LocalDate.now())) {
			valida = true;
		}
		return valida;
	}

	public static boolean DataInicioIgualAtual(LocalDate date) {
		boolean valida = false;
		if (date.isEqual(LocalDate.now())) {
			valida = true;
		}
		return valida;
	}

	public static boolean DataInicioIgualFinal(LocalDate dateIni, LocalDate fim) {
		boolean valida = false;
		if (dateIni.isEqual(fim)) {
			valida = true;
		}
		return valida;
	}

	public static boolean DataInicMenorQueFinal(LocalDate dateIni, LocalDate fim) {
		boolean valida = false;
		if (dateIni.isBefore(fim)) {
			valida = true;
		}
		return valida;
	}
}
