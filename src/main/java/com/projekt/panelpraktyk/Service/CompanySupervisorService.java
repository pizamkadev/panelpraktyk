package com.projekt.panelpraktyk.Service;

import com.projekt.panelpraktyk.Repository.CompanySupervisorRepository;
import com.projekt.panelpraktyk.models.CompanySupervisor;
import org.springframework.stereotype.Service;

@Service
public class CompanySupervisorService {

    private final CompanySupervisorRepository repository;

    public CompanySupervisorService(CompanySupervisorRepository repository) {
        this.repository = repository;
    }

    public CompanySupervisor addSupervisor(CompanySupervisor supervisor) {
        return repository.save(supervisor);
    }
}