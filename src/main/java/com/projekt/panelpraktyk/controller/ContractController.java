package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.models.Company;
import com.projekt.panelpraktyk.models.Contract;
import com.projekt.panelpraktyk.repository.CompanyRepository;
import com.projekt.panelpraktyk.service.ContractService;
import com.projekt.panelpraktyk.service.PdfGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    private final PdfGeneratorService pdfService;
    private final CompanyRepository companyRepository;

    @PostMapping("/generate/{companyId}")
    public ResponseEntity<byte[]> generateAndDownload(@PathVariable Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono firmy o ID: " + companyId));

        Contract contract = contractService.createContractForCompany(company);

        byte[] pdfContent = pdfService.generateContractPdf(contract);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("umowa_" + companyId + ".pdf")
                .build());

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}