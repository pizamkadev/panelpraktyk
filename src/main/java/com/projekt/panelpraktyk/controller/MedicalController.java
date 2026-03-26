package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.models.Company;
import com.projekt.panelpraktyk.models.Student;
import com.projekt.panelpraktyk.repository.CompanyRepository;
import com.projekt.panelpraktyk.repository.StudentRepository;
import com.projekt.panelpraktyk.service.MedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/referrals")
@RequiredArgsConstructor
public class MedicalController {

    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final MedicalService pdfService;

    @PostMapping("/generate-for-company/{companyId}")
    public ResponseEntity<byte[]> generateForCompany(@PathVariable Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono firmy"));

        List<Student> students = studentRepository.findByCompany(company);

        byte[] pdf = pdfService.generateGroupReferral(students);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment()
                .filename("skierowania" + company.getName() + ".pdf").build());

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}