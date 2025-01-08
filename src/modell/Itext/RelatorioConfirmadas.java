/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell.Itext;

import modell.Inscricoes;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Muzime
 */
public class RelatorioConfirmadas {

    private static PdfPCell cell;
    private static PdfPTable table;

    public RelatorioConfirmadas() {

    }

    public void relatorio(ArrayList<Inscricoes> ins) {
        String dest = "Relatorio_Evento" + ins.getFirst().getNomeEvento() + ".pdf";
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            Paragraph paragraph;
            paragraph = new Paragraph("\nRELATÓRIO DE INSCRIÇÕES CONFIRMADAS" , FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
            paragraph.setAlignment(1);
            document.add(paragraph);
            paragraph = new Paragraph("\n\nNome do Evento "+ ins.getFirst().getNomeEvento() , FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
            paragraph.setAlignment(1);
            document.add(paragraph);
            
            paragraph = new Paragraph("\n\n\n");
            document.add(paragraph);
            paragraph = new Paragraph("Tabela de inscrições\n\n", FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
            paragraph.setAlignment(1);
            document.add(paragraph);
            table = new PdfPTable(5);

            cell = new PdfPCell(new Paragraph("Nome do Evento"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            cell.setPadding(10.0f);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Nome do Participante"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            cell.setPadding(10.0f);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Data de Inscrição"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            cell.setPadding(10.0f);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Tipo de Bilhete"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            cell.setPadding(10.0f);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Status da Inscrição"));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            cell.setPadding(10.0f);
            table.addCell(cell);
            int total=0;
            for (Inscricoes s : ins) {
                table.addCell(s.getNomeEvento());
                table.addCell(s.getNomeParticipante());
                table.addCell(s.getDataInscricao());
                table.addCell(s.getTipo_Bilhete());
                table.addCell(s.getStatus());
                total++;
            }
            document.add(table);
            paragraph = new Paragraph("Total: "+total , FontFactory.getFont(FontFactory.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
            paragraph.setAlignment(0);
            document.add(paragraph);
            document.close();

            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                desktop.open(new File(dest));
            }

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
