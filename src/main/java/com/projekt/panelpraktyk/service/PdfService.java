package com.projekt.panelpraktyk.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.projekt.panelpraktyk.models.Company;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PdfService {

    public void generateCompanyPdf(Company company, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph title = new Paragraph("INFORMACJE O FIRMIE", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" "));

        document.add(new Paragraph("Nazwa: " + company.getName()));
        document.add(new Paragraph("Adres: " + company.getAddress()));
        document.add(new Paragraph("NIP: " + company.getNip()));
        document.add(new Paragraph("REGON: " + company.getRegon()));
        document.add(new Paragraph("KRS: " + company.getKrs()));
        document.add(new Paragraph("Telefon: " + company.getPhoneNumber()));

        document.close();
    }
}