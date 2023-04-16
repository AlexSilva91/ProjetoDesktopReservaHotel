/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

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
