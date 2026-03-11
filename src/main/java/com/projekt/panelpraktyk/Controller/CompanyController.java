package com.projekt.panelpraktyk.Controller;

import com.projekt.panelpraktyk.Service.CompanyService;
import com.projekt.panelpraktyk.models.Company;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }
}