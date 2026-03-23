package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanyService;
import com.projekt.panelpraktyk.service.PdfService;
import com.projekt.panelpraktyk.models.Company;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

public class CompanyController {

    private final CompanyService companyService;
    private final PdfService pdfService;

    public CompanyController(CompanyService companyService, PdfService pdfService) {
        this.companyService = companyService;
        this.pdfService = pdfService;
    }

    @PostMapping("/api/company")
    public Company addCompany(@Valid @RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping("/api/companies")
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/api/companies/{id}")
    public Company getCompany(@Valid @PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/api/companies/{id}/pdf")
    public void generateCompanyPdf(@Valid @PathVariable Long id, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=company_report_" + id + ".pdf");

        Company company = companyService.getCompanyById(id);

        pdfService.generateCompanyPdf(company, response);
    }

    @PutMapping("/api/company/edit/{id}")
    public Company updateCompany(@Valid @PathVariable Long id, @Valid @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/api/company/delete/{id}")
    public void deleteCompany(@Valid @PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }

    @PutMapping("/api/company/archive/{id}")
    public Company archiveCompany(@PathVariable Long id) {
        return companyService.archiveCompany(id);
    }

    @GetMapping("/api/company/archived")
    public List<Company> getArchivedCompanies() {
        return companyService.findAllArchived();
    }
}