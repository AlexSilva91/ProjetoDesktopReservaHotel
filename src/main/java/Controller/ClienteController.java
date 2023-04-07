/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import main.java.ConnectionFactory.ConnectionFactory;
import main.java.DAO.ClienteDao;
import main.java.View.CadastroCliente;
import main.java.View.ClienteView;
import main.java.View.DeletarPerfil;
import main.java.View.EditarPerfil;
import main.java.model.Cliente;

/**
 *
 * @author HP - 4300
 */
public class ClienteController {

    private final EntityManager em = ConnectionFactory.getConnection();
    private final ClienteDao clienteDao = new ClienteDao();
    private static Cliente cliente = new Cliente();
    private final EditarPerfil editarPerfil = new EditarPerfil();
    private final ClienteView clienteView = new ClienteView();
    private final DeletarPerfil deletarPerfil = new DeletarPerfil();
    private final CadastroCliente cadastroCliente = null;
    private static int cpf;

    public void CadastrarCliente(Cliente c) {
        try {
            cliente = this.Consulta(c.getCpf());
            if (cliente == null) {
                clienteDao.SaveCliente(c);
                JOptionPane.showMessageDialog(null, "Dados Cadastrados!");
            } else {
                JOptionPane.showMessageDialog(null, "Cpf já cadastrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro! Dados inválidos!\n"+e.getMessage());
        }
    }

    public void AtualizaDadosCliente() {

        try {
            cliente = this.Consulta(cpf);
            if (cliente.getCpf() == cpf) {
                em.detach(cliente);
                cliente.setNome(editarPerfil.getNome());
                cliente.setEmail(editarPerfil.getEmail());
                cliente.setTelefone(editarPerfil.getTelefone());
                clienteDao.AtualizaCliente(cliente);
                editarPerfil.ExibeMessageAtualizado();
                clienteView.recebeCliente(cliente);
            }
        } catch (Exception e) {
            editarPerfil.ExibeErro(e);
        }

    }

    public Cliente Consulta(int cpf) {
        return cliente = this.clienteDao.findById(cpf);
    }

    public void AtualizaExibicao(int cpf) {
        cliente = Consulta(cpf);
        clienteView.setCliente(cliente);
        clienteView.recebeCPF(cliente);
        System.out.println(cliente.getNome());
    }

    public void deletaCliente(int cpf) {
        cliente = Consulta(cpf);
        try {
            this.clienteDao.removeCliente(cliente.getCpf());
            this.deletarPerfil.Exibe();
            this.deletarPerfil.fecha();
        } catch (Exception e) {
            this.deletarPerfil.Erro(e);
        }
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        ClienteController.cpf = cpf;
    }

}
