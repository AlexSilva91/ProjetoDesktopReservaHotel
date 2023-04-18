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
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.model.Cliente;
import main.java.resources.conversor.Conversor;

/**
 *
 * @author HP - 4300
 */
public class RelatorioPDF implements Relatorios {

    private Cliente cliente;
    private Document document;
    private String caminhoRelatorio = "C:\\Users\\HP - 4300\\Documents\\Relatorios\\relatorio.pdf";

    public void GeraRalatorioPdf(String dados) {
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoRelatorio));
            document.open();
            Paragraph paragraph = new Paragraph(dados);
            document.add(paragraph);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelatorioPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

    public RelatorioPDF(Cliente cliente) {
        this.cliente = cliente;
        this.document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminhoRelatorio));
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
                "\n--------------------------------------------------------------",
                new Font(Font.BOLD, 18)));

        Paragraph paragraphTitulo = new Paragraph();
        paragraphTitulo.setAlignment(Element.ALIGN_CENTER);
        paragraphTitulo.add(new Chunk(
                "RELATORIO DE RESERVAS DO CLIENTE",
                new Font(Font.TIMES_ROMAN, 24)));
        this.document.add(paragraphTitulo);

        this.document.add(new Paragraph("\n"));

        Paragraph paragraphData = new Paragraph();
        paragraphData.setAlignment(Element.ALIGN_CENTER);
        paragraphData.add(new Chunk(
                "Data de emissão: " + Conversor.conversorData(LocalDate.now()),
                new Font(Font.TIMES_ROMAN, 24)));
        this.document.add(paragraphData);

        this.document.add(new Paragraph("\n"));

        Paragraph paragraphCliente = new Paragraph();
        paragraphCliente.setAlignment(Element.ALIGN_LEFT);
        paragraphCliente.add(new Chunk(
                "\nCliente: " + this.cliente.getNome(),
                new Font(Font.TIMES_ROMAN, 18)));
        paragraphCliente.add(new Chunk(
                "\nEmail: " + this.cliente.getEmail(),
                new Font(Font.TIMES_ROMAN, 18)));
        paragraphCliente.add(new Chunk(
                "\nCPF: "+ this.cliente.getCpf(),
                new Font(Font.TIMES_ROMAN, 18)));
        paragraphCliente.add(new Chunk(
                "\nTelefone: " + this.cliente.getTelefone(),
                new Font(Font.TIMES_ROMAN, 18)));
        this.document.add(paragraphCliente);

        this.document.add(paragraphPulaLinha);
    }

    @Override
    public void gerarCorpo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gerarRodape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimir() {
        if (this.document != null && this.document.isOpen()) {
            this.document.close();
        }
    }
}
