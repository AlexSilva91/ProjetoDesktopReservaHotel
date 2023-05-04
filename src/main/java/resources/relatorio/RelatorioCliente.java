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
import com.lowagie.text.PageSize;
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
public class RelatorioCliente implements Relatorios {

    private static Cliente cliente;
    private Document document;
    private String caminhoRelatorio = "C:\\Users\\HP - 4300\\Documents\\Relatorios\\";

    public RelatorioCliente(Cliente cliente) {
        RelatorioCliente.cliente = cliente;
        this.document = new Document(PageSize.A4, 50, 50, 70, 70);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoRelatorio + cliente.getNome() + ".pdf"));
            this.document.open();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelatorioReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void gerarCabecalho() {
        this.document.setMargins(50, 50, 70, 70);
        this.document.setMarginMirroring(true);
        Paragraph paragraphLinhas = new Paragraph();
        paragraphLinhas.setAlignment(Element.ALIGN_CENTER);
        paragraphLinhas.add(new Chunk("\n-----------------------------------------------------------------------",
                new Font(Font.TIMES_ROMAN, 14)));

        Paragraph pTitulo = new Paragraph();
        pTitulo.setAlignment(Element.ALIGN_CENTER);
        pTitulo.add(new Chunk("Informações do cliente: " + cliente.getNome().toUpperCase(),
                new Font(Font.TIMES_ROMAN, 16)));

        this.document.add(pTitulo);
        this.document.add(new Paragraph("\n"));

        Paragraph data = new Paragraph();
        data.setAlignment(Element.ALIGN_CENTER);
        data.add(new Chunk("Data de emissão: " + Conversor.conversorData(LocalDate.now()),
                new Font(Font.TIMES_ROMAN, 16)));

        this.document.add(data);
        this.document.add(paragraphLinhas);
        this.document.add(new Paragraph("\n"));
    }

    @Override
    public void gerarCorpo(List<Reserva> r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void gerarCorpo() {
        this.document.add(new Paragraph("\n"));
        Paragraph infoCliente = new Paragraph();
        infoCliente.setAlignment(Element.ALIGN_CENTER);
        infoCliente.add(new Chunk("CPF: " + cliente.getCpf() + "\nE-mail: " + cliente.getEmail()
                + "\nTelefone: " + cliente.getTelefone(),
                new Font(Font.TIMES_ROMAN, 12)));
        this.document.add(infoCliente);
        this.document.add(new Paragraph("\n"));
    }

    @Override
    public void gerarRodape() {
        this.document.setMargins(50, 50, 70, 70);
        this.document.setMarginMirroring(true);
        Paragraph paragraphLinhas = new Paragraph();
        paragraphLinhas.setAlignment(Element.ALIGN_CENTER);
        paragraphLinhas.add(new Chunk("\n-----------------------------------------------------------------------",
                new Font(Font.TIMES_ROMAN, 14)));

        this.document.add(paragraphLinhas);
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
