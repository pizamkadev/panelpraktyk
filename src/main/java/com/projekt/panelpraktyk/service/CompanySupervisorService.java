package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.repository.CompanySupervisorRepository;
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

    public void deleteSupervisorById(Long supervisorId) {
        repository.deleteById(supervisorId);
    }
}