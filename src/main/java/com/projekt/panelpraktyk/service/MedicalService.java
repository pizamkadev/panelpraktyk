package com.projekt.panelpraktyk.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MedicalService {

    public byte[] generateGroupReferral(List<Student> students) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            PdfWriter.getInstance(document, out);
            document.open();


            BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
            Font bold = new Font(helvetica, 10, Font.BOLD);
            Font normal = new Font(helvetica, 10, Font.NORMAL);
            Font small = new Font(helvetica, 8, Font.NORMAL);
            Font titleFont = new Font(helvetica, 14, Font.BOLD);

            for (Student student : students) {
                document.add(new Paragraph("oznaczenie placówki dydaktycznej", small));

                Paragraph title = new Paragraph("\nSKIEROWANIE NA BADANIE LEKARSKIE", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                document.add(new Paragraph("\nNa podstawie Rozporządzenia Ministra Zdrowia z dnia 26 sierpnia 2019 r. w sprawie badań lekarskich kandydatów do szkół ponadpodstawowych lub wyższych, uczniów, studentów oraz uczestników kwalifikacyjnych kursów zawodowych (Dz.U. 2019 poz. 1651).", small));

                document.add(new Paragraph("\nI. Dane osoby kierowanej na badanie:", bold));
                Paragraph name = new Paragraph(student.getName() + " " + student.getLastname(), bold);
                name.setAlignment(Element.ALIGN_CENTER);
                document.add(name);
                document.add(new Paragraph("imię i nazwisko kandydata / ucznia", small));

                String bDate = student.getBirthDate() != null ? student.getBirthDate().format(dtf) : "..........";
                String pesel = student.getPesel() != null ? student.getPesel() : "..........";
                document.add(new Paragraph("\n" + bDate + "                                       " + pesel, normal));
                document.add(new Paragraph("data urodzenia                                     numer PESEL", small));

                document.add(new Paragraph("\nII. Skierowana osoba jest:", bold));
                document.add(new Paragraph("[X] badania okresowe ucznia szkoły ponadpodstawowej", normal));

                document.add(new Paragraph("\nTechnik Programista - " + student.getStudentClass(), bold));
                document.add(new Paragraph("zakres praktycznej nauki zawodu", small));

                document.add(new Paragraph("\nIII. Czynniki szkodliwe:", bold));
                document.add(new Paragraph("- praca przy komputerze powyżej 4 godzin dziennie\n- wymuszona pozycja ciała", normal));

                document.add(new Paragraph("\nŁódź, dn. " + LocalDate.now().format(dtf), normal));
                document.add(new Paragraph("\n\n..........................................                ..........................................", small));
                document.add(new Paragraph("miejscowość, data                                  pieczątka i podpis", small));

                document.newPage();
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}


