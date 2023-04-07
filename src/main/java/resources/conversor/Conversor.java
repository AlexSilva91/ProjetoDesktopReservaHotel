/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.conversor;

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
        LocalTime time = LocalTime.of(Integer.parseInt(hora.substring(0, 2)),
                Integer.parseInt(hora.substring(3, 5)));
        return time;
    }
}
