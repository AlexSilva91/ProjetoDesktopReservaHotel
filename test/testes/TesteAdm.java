/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import main.java.DAO.AdmDao;
import main.java.model.Adm;

/**
 *
 * @author HP - 4300
 */
public class TesteAdm {

    public static void main(String[] args) {
        Adm adm = new Adm(14242744, "Joao", "JaoSilva@gmail.com");
        AdmDao admDao = new AdmDao();
        admDao.SaveUser(adm);
    }
}
