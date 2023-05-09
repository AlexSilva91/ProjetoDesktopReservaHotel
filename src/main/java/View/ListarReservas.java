/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.View;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.java.Controller.ClienteController;
import main.java.Controller.ReservaController;
import main.java.model.Cliente;
import main.java.model.Reserva;
import main.java.resources.conversor.Conversor;
import main.java.resources.relatorio.RelatorioReservaEspecifica;

/**
 *
 * @author HP - 4300
 */
public class ListarReservas extends javax.swing.JFrame {

	private static List<Reserva> listClienteReserva = new ArrayList<>();
	private static List<Cliente> listCliente = new ArrayList<>();
	private final ReservaController reservaController = new ReservaController();
	private final ClienteController clienteController = new ClienteController();
	private Reserva reserva = new Reserva();
	private Cliente cliente = new Cliente();

	/**
	 * Creates new form ListarReservas
	 */
	public ListarReservas() {
		initComponents();
		this.setDefaultCloseOperation(0);
		preecherTabela();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jTable = new javax.swing.JScrollPane();
		tabelaReservaCliente = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Reservas");
		setResizable(false);

		jButton1.setBackground(new java.awt.Color(0, 153, 0));
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("Aprovar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new java.awt.Color(204, 0, 0));
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setText("Recusar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setBackground(new java.awt.Color(255, 76, 0));
		jButton3.setForeground(new java.awt.Color(255, 255, 255));
		jButton3.setText("Relatório");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setBackground(new java.awt.Color(102, 102, 102));
		jButton4.setForeground(new java.awt.Color(255, 255, 255));
		jButton4.setText("Voltar");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(19, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jButton3)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel1Layout.createSequentialGroup()
														.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
																78, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(17, 17, 17))))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(jButton1)
						.addGap(18, 18, 18).addComponent(jButton2).addGap(18, 18, 18).addComponent(jButton3)
						.addGap(18, 18, 18).addComponent(jButton4).addContainerGap(31, Short.MAX_VALUE)));

		tabelaReservaCliente.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CPF_Cliente", "Inicio", "Final", "Hora", "Quarto", "Status", "Valor" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTable.setViewportView(tabelaReservaCliente);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jTable, javax.swing.GroupLayout.PREFERRED_SIZE, 563,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jTable, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE).addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		if (tabelaReservaCliente.getSelectedRowCount() == 1) {
			int indice = tabelaReservaCliente.getSelectedRow();
			reserva = listClienteReserva.get(indice);
			if (("cancelada").equals(reserva.getStatus()) || ("recusada").equals(reserva.getStatus())
					|| ("aprovada").equals(reserva.getStatus())) {
				JOptionPane.showMessageDialog(this, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				reserva.setStatus("aprovada");
				reservaController.AtualizarReserva(reserva);
				preecherTabela();
			}
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		this.dispose();
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		if (tabelaReservaCliente.getSelectedRowCount() == 1) {
			int indice = tabelaReservaCliente.getSelectedRow();
			reserva = listClienteReserva.get(indice);
			if (("cancelada").equals(reserva.getStatus()) || ("recusada").equals(reserva.getStatus())
					|| ("aprovada").equals(reserva.getStatus())) {
				JOptionPane.showMessageDialog(this, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				reserva.setStatus("recusada");
				reservaController.AtualizarReserva(reserva);
				preecherTabela();
			}
		}
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		if (tabelaReservaCliente.getSelectedRowCount() > 0) {
			int indice = tabelaReservaCliente.getSelectedRow();
			try {
				reserva = listClienteReserva.get(indice);
				cliente = listCliente.get(indice);
				LocalTime time = LocalTime.now();
				String nome = "Reserva " + cliente.getNome() + " " + time.getSecond() + ".pdf";
				RelatorioReservaEspecifica reservaEspecifica = new RelatorioReservaEspecifica(cliente, nome);
				reservaEspecifica.gerarCabecalho();
				reservaEspecifica.gerarCorpo(reserva);
				reservaEspecifica.gerarRodape();
				reservaEspecifica.imprimir();
				JOptionPane.showMessageDialog(this, "Relatorio gerado!", "Salvo", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}// GEN-LAST:event_jButton3ActionPerformed

	private void preecherTabela() {
		Reserva reserva = null;
		listClienteReserva.clear();
		listClienteReserva = reservaController.ConsultaReserva();
		listCliente = clienteController.ConsultCliente();
		DefaultTableModel model = (DefaultTableModel) tabelaReservaCliente.getModel();
		model.setRowCount(0);
		for (Reserva element : listClienteReserva) {
			model.addRow(new Object[] { element.getCpf_cliente(), Conversor.conversorData(element.getDataInicial()),
					Conversor.conversorData(element.getDataFinal()), element.getHoraEntrada(), element.getQuarto(),
					element.getStatus(), element.getValorDiaria() });
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ListarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ListarReservas().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jTable;
	private javax.swing.JTable tabelaReservaCliente;
	// End of variables declaration//GEN-END:variables

}
