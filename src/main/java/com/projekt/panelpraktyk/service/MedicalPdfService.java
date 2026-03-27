package com.projekt.panelpraktyk.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.projekt.panelpraktyk.models.ReferralMedical;
import com.projekt.panelpraktyk.models.Student;
import com.projekt.panelpraktyk.repository.StudentRepository;
import com.projekt.panelpraktyk.repository.ReferralRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalPdfService {

    private final ReferralRepository referralRepository;
    private final StudentRepository studentRepository;

    public boolean hasValidMedicalExam(Long studentId) {
        List<ReferralMedical> referrals = referralRepository.findAllByStudentId(studentId);
        LocalDate today = LocalDate.now();

        for (ReferralMedical r : referrals) {
            if (r.getExpirationDate() != null) {
                if (r.getExpirationDate().isAfter(today) || r.getExpirationDate().isEqual(today)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Transactional
    public ReferralMedical createReferral(ReferralMedical referral, Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Nie znaleziono studenta"));

        referral.setStudent(student);
        return referralRepository.save(referral);
    }

    public ByteArrayInputStream generateReferralStream(Long referralId) throws IOException, DocumentException {

        ReferralMedical referral = referralRepository.findById(referralId).orElseThrow(() -> new RuntimeException("Nie znaleziono skierowania"));

        Student student = referral.getStudent();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 40, 40, 40, 40);
        PdfWriter.getInstance(document, out);

        document.open();

        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
        Font fTitle = new Font(bf, 12, Font.BOLD);
        Font fNormal = new Font(bf, 10, Font.NORMAL);
        Font fSmall = new Font(bf, 8, Font.NORMAL);
        Font fBold = new Font(bf, 10, Font.BOLD);

        Paragraph header = new Paragraph("SKIEROWANIE", fTitle);
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);

        Paragraph law = new Paragraph("\nStosownie do przepisów Rozporządzenia Ministra Zdrowia z dnia 26 sierpnia 2019 r. w sprawie badań lekarskich kandydatów do szkół... (Dz. U. z 2019 r., poz.1651)\n\n", fNormal);
        law.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(law);



        document.add(new Paragraph("I. Kieruję na badanie lekarskie:", fNormal));

        Paragraph name = new Paragraph(student.getName() + " " + student.getLastname(), fBold);
        name.setAlignment(Element.ALIGN_CENTER);
        document.add(name);

        Paragraph nameDesc = new Paragraph("imię i nazwisko kandydata / ucznia / studenta / słuchacza", fSmall);
        nameDesc.setAlignment(Element.ALIGN_CENTER);
        document.add(nameDesc);

        PdfPTable idTable = new PdfPTable(2);
        idTable.setWidthPercentage(100);
        idTable.setSpacingBefore(10f);

        idTable.addCell(createCell("................................", Element.ALIGN_CENTER, fBold));
        idTable.addCell(createCell("................................", Element.ALIGN_CENTER, fBold));
        idTable.addCell(createCell("data urodzenia", Element.ALIGN_CENTER, fSmall));
        idTable.addCell(createCell("numer PESEL/Paszport", Element.ALIGN_CENTER, fSmall));
        document.add(idTable);



        document.add(new Paragraph("\nII. Skierowana osoba jest:", fNormal));
        document.add(new Paragraph("[  ] kandydatem do szkoły ponadpodstawowej", fNormal));
        document.add(new Paragraph("[  ] nieletnim kandydatem na kwalifikacyjny kurs zawodowy", fNormal));
        document.add(new Paragraph("[ X ] badania okresowe ucznia  szkoły ponadpodstawowej", fNormal));
        document.add(new Paragraph("[  ] pełnoletnim kandydatem na kwalifikacyjny kurs zawodowy*", fNormal));
        document.add(new Paragraph("[  ] nieletnim kandydatem na kwalifikacyjny kurs zawodowy", fNormal));
        document.add(new Paragraph("[  ] pełnoletnim słuchaczem na kwalifikacyjny kurs zawodowy*", fNormal));
        document.add(new Paragraph("[  ] przygotowanie do uzyskania umiejętności kierowania pojazdem silnikowym kat A,B,T", fNormal));
        document.add(new Paragraph("[  ] przygotowanie do uzyskania umiejętności kierowania pojazdem silnikowym kat C,D", fNormal));
        document.add(new Paragraph("[  ] doktorant", fNormal));
        document.add(new Paragraph("*Badanie płatne - art. 21 a ustawy z dnia 27.06.1997 r. o służbie medycyny pracy (tj. Dz. U. z 2019 poz. 1175).", fSmall));

        Paragraph p1 = new Paragraph("\n" + referral.getPosition(), fBold);
        p1.setAlignment(Element.ALIGN_CENTER);
        document.add(p1);

        Paragraph p2 = new Paragraph("zakres praktycznej nauki zawodu albo kształcenia", fSmall);
        p2.setAlignment(Element.ALIGN_CENTER);
        document.add(p2);



        document.add(new Paragraph("\nIII. W trakcie odbywania praktycznej nauki zawodu w/w będzie narażony na działanie:", fNormal));
        document.add(new Paragraph("następujących czynników szkodliwych, uciążliwych lub niebezpiecznych dla zdrowia:", fNormal));
        document.add(new Paragraph(referral.getHarmfulFactors(), fBold));



        PdfPTable footer = new PdfPTable(2);
        footer.setWidthPercentage(100);
        footer.setSpacingBefore(50f);

        String leftText = "Łódź, dn. " + java.time.LocalDate.now() + "\n...........................................................\n(miejscowość, data wystawienia skierowania)";
        footer.addCell(createCell(leftText, Element.ALIGN_CENTER, fSmall));

        String rightText = "\n...........................................................\npieczątka i podpis kierującego na badanie lekarskie";
        footer.addCell(createCell(rightText, Element.ALIGN_CENTER, fSmall));

        document.add(footer);

        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

    private PdfPCell createCell(String text, int align, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(align);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
}