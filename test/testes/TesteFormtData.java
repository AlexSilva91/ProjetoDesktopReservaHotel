/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.time.LocalDate;
import main.java.resources.conversor.ConversorData;


/**
 *
 * @author HP - 4300
 */
public class TesteFormtData {
    public static void main(String[] args) {
        
        String data = "2023/03/27";
        LocalDate cd = new ConversorData().ConversorData(data);
        System.out.println(cd);
       
    }
}
