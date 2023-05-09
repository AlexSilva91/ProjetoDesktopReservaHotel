/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.relatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import main.java.model.Cliente;
import main.java.model.Reserva;
import main.java.resources.conversor.Conversor;

/**
 *
 * @author HP - 4300
 */
public class RelatorioReserva implements Relatorios {

	private Cliente cliente;
	private Document document;
	private String caminhoRelatorio = "C:\\Users\\HP - 4300\\Documents\\Relatorios\\";

	public RelatorioReserva(Cliente cliente, String nome) {
		this.cliente = cliente;
		this.document = new Document(PageSize.A4, 50, 50, 70, 70);
		try {
			PdfWriter.getInstance(document, new FileOutputStream(caminhoRelatorio + nome));
			this.document.open();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(RelatorioReserva.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void gerarCabecalho() {
		this.document.setMargins(50, 50, 70, 70);
		this.document.setMarginMirroring(true);
		Paragraph paragraphPulaLinha = new Paragraph();
		paragraphPulaLinha.setAlignment(Element.ALIGN_CENTER);
		paragraphPulaLinha
				.add(new Chunk("\n--------------------------------------------------------------------------------",
						new Font(Font.TIMES_ROMAN, 14)));

		Paragraph p = new Paragraph(new Chunk("------------------", new Font(Font.TIMES_ROMAN, 14)));
		p.setAlignment(Element.ALIGN_CENTER);

		Paragraph paragraphTitulo = new Paragraph();
		paragraphTitulo.setAlignment(Element.ALIGN_CENTER);
		paragraphTitulo.add(new Chunk("RELATORIO DE RESERVAS DO CLIENTE", new Font(Font.TIMES_ROMAN, 16)));
		this.document.add(paragraphTitulo);

		this.document.add(new Paragraph("\n"));

		Paragraph paragraphData = new Paragraph();
		paragraphData.setAlignment(Element.ALIGN_CENTER);
		paragraphData.add(new Chunk("Data de emissão: " + Conversor.conversorData(LocalDate.now()) + "\n",
				new Font(Font.TIMES_ROMAN, 16)));
		this.document.add(paragraphData);

		this.document.add(paragraphPulaLinha);
		this.document.add(p);

		Paragraph paragraphCliente = new Paragraph();
		paragraphCliente.setAlignment(Element.ALIGN_CENTER);
		paragraphCliente.add(new Chunk("\nCliente: " + this.cliente.getNome(), new Font(Font.TIMES_ROMAN, 12)));
		paragraphCliente.add(new Chunk("\nEmail: " + this.cliente.getEmail(), new Font(Font.TIMES_ROMAN, 12)));
		paragraphCliente.add(new Chunk("\nCPF: " + this.cliente.getCpf(), new Font(Font.TIMES_ROMAN, 12)));
		paragraphCliente.add(new Chunk("\nTelefone: " + this.cliente.getTelefone(), new Font(Font.TIMES_ROMAN, 12)));
		this.document.add(paragraphCliente);

		this.document.add(p);
		this.document.add(paragraphPulaLinha);
	}

	@Override
	public void gerarCorpo(List<Reserva> r) {
		this.document.setMargins(50, 50, 70, 70);
		this.document.setMarginMirroring(true);
		Paragraph paragraphTituloCorpo = new Paragraph(new Chunk("Reservas\n", new Font(Font.TIMES_ROMAN, 14)));
		paragraphTituloCorpo.setAlignment(Element.ALIGN_CENTER);
		this.document.add(paragraphTituloCorpo);

		Paragraph paragraphCorpo = new Paragraph();
		paragraphCorpo.setAlignment(Element.ALIGN_JUSTIFIED);
		double total = 0;
		for (Reserva reserva : r) {
			total += reserva.getValorDiaria();
			paragraphCorpo.add(new Chunk(
					"Data de entrada: " + Conversor.conversorData(reserva.getDataInicial()) + "\nData de saída: "
							+ Conversor.conversorData(reserva.getDataInicial()) + "\nHora de entrada: "
							+ reserva.getHoraEntrada() + "\nStatus: " + reserva.getStatus() + "\nQuarto: "
							+ reserva.getQuarto() + "\nValor da diária: " + reserva.getValorDiaria() + "\n\n",
					new Font(Font.TIMES_ROMAN, 12)));
		}
		this.document.add(paragraphCorpo);
		Paragraph paragraphTotal = new Paragraph(new Chunk("Valor total: R$" + total, new Font(Font.BOLD, 14)));
		paragraphTotal.setAlignment(Element.ALIGN_RIGHT);
		this.document.add(paragraphTotal);

	}

	@Override
	public void gerarRodape() {
		this.document.setMargins(50, 50, 70, 70);
		this.document.setMarginMirroring(true);
		Paragraph paragraphPulaLinha = new Paragraph();
		paragraphPulaLinha.setAlignment(Element.ALIGN_CENTER);
		paragraphPulaLinha
				.add(new Chunk("\n--------------------------------------------------------------------------------",
						new Font(Font.TIMES_ROMAN, 14)));

		this.document.add(paragraphPulaLinha);
		this.document.add(new Paragraph("\n"));

		Paragraph paragraphRodaPe = new Paragraph();
		paragraphRodaPe.setAlignment(Element.ALIGN_CENTER);
		paragraphRodaPe.add(new Chunk("Pousada do Sossego", new Font(Font.TIMES_ROMAN, 10)));
		this.document.add(paragraphRodaPe);

	}

	@Override
	public void imprimir() {
		if (this.document != null && this.document.isOpen()) {
			this.document.close();
		}
	}
}
