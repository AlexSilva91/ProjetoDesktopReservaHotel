/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import main.java.Controller.ClienteController;
import main.java.DAO.AdmDao;
import main.java.model.Adm;
import main.java.model.Cliente;
import main.java.model.UsuarioAbstrato;

/**
 *
 * @author HP - 4300
 */
public class TestIntance {

    public static void main(String[] args) {
        UsuarioAbstrato abstrato;
        UsuarioAbstrato abstrat;
        ClienteController controller = new ClienteController();
        AdmDao dao = new AdmDao();

        abstrato = controller.Consulta(12);
        abstrat = dao.findById(123);

        if (abstrato instanceof Cliente) {
            System.out.println("\nCliente: " + abstrato.getNome());
        }
        if (abstrat instanceof Adm) {
            System.out.println("\nAdm: " + abstrat.getNome());
        }
    }
}
