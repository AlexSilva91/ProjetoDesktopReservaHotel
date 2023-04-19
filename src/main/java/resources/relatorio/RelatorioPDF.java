/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.resources.relatorio;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.model.Cliente;
import main.java.model.Reserva;
import main.java.resources.conversor.Conversor;

/**
 *
 * @author HP - 4300
 */
public class RelatorioPDF implements Relatorios {

    private Cliente cliente;
    private Document document;
    private String caminhoRelatorio = "C:\\Users\\HP - 4300\\Documents\\Relatorios\\";

    public RelatorioPDF(Cliente cliente, String nome) {
        this.cliente = cliente;
        this.document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoRelatorio + nome));
            this.document.open();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelatorioPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void gerarCabecalho() {

        Paragraph paragraphPulaLinha = new Paragraph();
        paragraphPulaLinha.setAlignment(Element.ALIGN_CENTER);
        paragraphPulaLinha.add(new Chunk(
                "\n--------------------------------------------------------------------------------",
                new Font(Font.TIMES_ROMAN, 14)));

        Paragraph paragraphTitulo = new Paragraph();
        paragraphTitulo.setAlignment(Element.ALIGN_CENTER);
        paragraphTitulo.add(new Chunk(
                "RELATORIO DE RESERVAS DO CLIENTE",
                new Font(Font.TIMES_ROMAN, 16)));
        this.document.add(paragraphTitulo);

        this.document.add(new Paragraph("\n"));

        Paragraph paragraphData = new Paragraph();
        paragraphData.setAlignment(Element.ALIGN_CENTER);
        paragraphData.add(new Chunk(
                "Data de emissão: " + Conversor.conversorData(LocalDate.now()),
                new Font(Font.TIMES_ROMAN, 16)));
        this.document.add(paragraphData);

        this.document.add(new Paragraph("\n"));
        this.document.add(paragraphPulaLinha);

        Paragraph paragraphCliente = new Paragraph();
        paragraphCliente.setAlignment(Element.ALIGN_CENTER);
        paragraphCliente.add(new Chunk(
                "\nCliente: " + this.cliente.getNome(),
                new Font(Font.TIMES_ROMAN, 12)));
        paragraphCliente.add(new Chunk(
                "\nEmail: " + this.cliente.getEmail(),
                new Font(Font.TIMES_ROMAN, 12)));
        paragraphCliente.add(new Chunk(
                "\nCPF: " + this.cliente.getCpf(),
                new Font(Font.TIMES_ROMAN, 12)));
        paragraphCliente.add(new Chunk(
                "\nTelefone: " + this.cliente.getTelefone(),
                new Font(Font.TIMES_ROMAN, 12)));
        this.document.add(paragraphCliente);

        this.document.add(paragraphPulaLinha);
    }

    @Override
    public void gerarCorpo(List<Reserva> r) {
        Paragraph paragraphTituloCorpo = new Paragraph(new Chunk(
                "Reservas", new Font(Font.TIMES_ROMAN, 14)));
        paragraphTituloCorpo.setAlignment(Element.ALIGN_CENTER);
        this.document.add(paragraphTituloCorpo);

        Paragraph paragraphCorpo = new Paragraph();
        paragraphCorpo.setAlignment(Element.ALIGN_CENTER);

        for (int i = 0; i < r.size(); i++) {
            Reserva reserva = r.get(i);
            paragraphCorpo.add(new Chunk("\n"));
            paragraphCorpo.add(new Chunk("Data inicial da reserva: "
                    + Conversor.conversorData(reserva.getDataInicial()),
                    new Font(Font.TIMES_ROMAN, 12)));
            paragraphCorpo.add(new Chunk(""));
            paragraphCorpo.add(new Chunk("\nHora de entrada: " + reserva.getHoraEntrada(),
                    new Font(Font.TIMES_ROMAN, 12)));
            paragraphCorpo.add(new Chunk(""));
            paragraphCorpo.add(new Chunk("\nData final da reserva: "
                    + Conversor.conversorData(reserva.getDataFinal()),
                    new Font(Font.TIMES_ROMAN, 12)));
            paragraphCorpo.add(new Chunk(""));
            paragraphCorpo.add(new Chunk("\nDiária: R$ " + reserva.getValorDiaria(),
                    new Font(Font.TIMES_ROMAN, 12)));
            paragraphCorpo.add(new Chunk(""));
            paragraphCorpo.add(new Chunk("\nQuarto: " + reserva.getQuarto(),
                    new Font(Font.TIMES_ROMAN, 12)));
            paragraphCorpo.add(new Chunk(""));
            paragraphCorpo.add(new Chunk("\nStatus: " + reserva.getStatus(),
                    new Font(Font.TIMES_ROMAN, 12)));
            paragraphCorpo.add(new Chunk("\n"));
            this.document.add(new Paragraph("\n"));
            this.document.add(paragraphCorpo);
        }

    }

    @Override
    public void gerarRodape() {
        Paragraph paragraphPulaLinha = new Paragraph();
        paragraphPulaLinha.setAlignment(Element.ALIGN_CENTER);
        paragraphPulaLinha.add(new Chunk(
                "\n--------------------------------------------------------------------------------",
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
