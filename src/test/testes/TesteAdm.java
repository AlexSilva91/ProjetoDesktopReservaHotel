package test.testes;

import main.java.DAO.AdmDao;
import main.java.model.Adm;

/**
 *
 * @author HP - 4300
 */
public class TesteAdm {

	public static void main(String[] args) {
		Adm adm = new Adm(125, "gerente", "gerente@gmail.com");
		AdmDao admDao = new AdmDao();
		admDao.SaveUser(adm);
	}
}
