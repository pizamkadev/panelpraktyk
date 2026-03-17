package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanyService;
import com.projekt.panelpraktyk.models.Company;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/api/companys")
    public Company addCompany(@Valid @RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@Valid @PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@Valid @PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }
}