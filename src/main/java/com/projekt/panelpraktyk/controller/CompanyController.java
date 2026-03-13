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
}