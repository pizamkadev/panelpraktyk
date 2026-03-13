package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.repository.CompanyRepository;

import com.projekt.panelpraktyk.models.Company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company addCompany(final Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}