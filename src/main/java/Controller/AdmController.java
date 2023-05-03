/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import main.java.DAO.AdmDao;
import main.java.model.Adm;

/**
 *
 * @author HP - 4300
 */
public class AdmController {

    private final AdmDao admDao = new AdmDao();

    public Adm busca(int id) {
        return admDao.findById(id);
    }
}
