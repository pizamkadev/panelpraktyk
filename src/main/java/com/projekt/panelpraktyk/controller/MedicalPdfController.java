package com.projekt.panelpraktyk.controller;

import com.lowagie.text.DocumentException;
import com.projekt.panelpraktyk.service.MedicalPdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projekt.panelpraktyk.models.ReferralMedical;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MedicalPdfController {

    private final MedicalPdfService MedicalPdfService;
    private final MedicalPdfService referralService;

    @PostMapping("/api/referral/add/{studentId}")
    public ReferralMedical addReferral(@RequestBody ReferralMedical referral, @PathVariable Long studentId) {
        return referralService.createReferral(referral, studentId);
    }

    @GetMapping("/api/referral/get/{referralId}")
    public ResponseEntity<InputStreamResource> generatePDF(@PathVariable Long referralId) throws IOException, DocumentException {

        ByteArrayInputStream bis = MedicalPdfService.generateReferralStream(referralId);

        HttpHeaders headers = new HttpHeaders();
        // attachment sprawia, że plik się pobiera, a nie otwiera w przeglądarce
        headers.add("Content-Disposition", "attachment; filename=skierowanie_" + referralId + ".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}