package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanyService;
import com.projekt.panelpraktyk.models.Company;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/api/companys")
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("/editcompany/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/companys/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }
}