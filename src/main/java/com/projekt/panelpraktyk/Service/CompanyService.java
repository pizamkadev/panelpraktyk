package com.projekt.panelpraktyk.Service;


import com.projekt.panelpraktyk.Repository.CompanyRepository;
import com.projekt.panelpraktyk.models.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void dodajFirme(Company firma) {
        companyRepository.save(firma);
    }//komentarztest
}