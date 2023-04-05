/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.conversor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HP - 4300
 */
public class ConversorData {
    
    public LocalDate ConversorData(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_INSTANT;
        LocalDate ld = LocalDate.parse(data, dtf);
        return ld;
    }
}
