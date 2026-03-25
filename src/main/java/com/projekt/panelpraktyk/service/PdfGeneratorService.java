package com.projekt.panelpraktyk.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.projekt.panelpraktyk.models.Contract;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGeneratorService {

    public byte[] generateContractPdf(Contract contract) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("UMOWA O ORGANIZACJĘ PRAKTYK ZAWODOWYCH", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Nr umowy: " + contract.getContractNumber()));
            document.add(new Paragraph("Data zawarcia: " + contract.getCreatedAt()));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Pomiędzy: Organizatorem Praktyk (Szkoła), a"));
            document.add(new Paragraph("Przyjmującym na praktyki: " + contract.getCompany().getName(), FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            document.add(new Paragraph("Adres: " + contract.getCompany().getAddress()));
            document.add(new Paragraph("NIP: " + contract.getCompany().getNip()));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Przedmiotem umowy jest odbycie praktyki zawodowej przez następujących uczniów:"));
            document.add(new Paragraph(" "));

            Table table = new Table(3);
            table.setWidth(100);
            table.addCell("LP");
            table.addCell("Imię i Nazwisko");
            table.addCell("Klasa");

            int count = 1;
            for (Student s : contract.getStudents()) {
                table.addCell(String.valueOf(count++));
                table.addCell(s.getName() + " " + s.getLastname()); //
                table.addCell(s.getStudentClass()); //
            }
            document.add(table);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("... (reszta warunków umowy) ..."));

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}