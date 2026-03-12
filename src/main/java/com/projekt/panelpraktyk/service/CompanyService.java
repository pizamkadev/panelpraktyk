package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.repository.CompanyRepository;

import com.projekt.panelpraktyk.models.Company;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company addCompany(final Company company) {
        return companyRepository.save(company);
    }
}