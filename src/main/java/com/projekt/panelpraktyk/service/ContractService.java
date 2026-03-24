package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.models.Company;
import com.projekt.panelpraktyk.models.Contract;
import com.projekt.panelpraktyk.models.Student;
import com.projekt.panelpraktyk.repository.ContractRepository;
import com.projekt.panelpraktyk.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final StudentRepository studentRepository;

    public Contract createContractForCompany(Company company) {
        List<Student> students = studentRepository.findByCompany(company);

        if (students.isEmpty()) {
            throw new RuntimeException("Brak uczniów przypisanych do firmy: " + company.getName());
        }
        Contract contract = Contract.builder()
                .company(company)
                .students(students)
                .createdAt(LocalDate.now())
                .contractNumber("Praktyki/" + LocalDate.now().getYear() + "/" + company.getId())
                .build();

        return contractRepository.save(contract);
    }
}