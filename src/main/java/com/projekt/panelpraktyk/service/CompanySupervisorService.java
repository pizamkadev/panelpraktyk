package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.repository.CompanySupervisorRepository;
import com.projekt.panelpraktyk.models.CompanySupervisor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanySupervisorService {

    private final CompanySupervisorRepository repository;

    public CompanySupervisorService(CompanySupervisorRepository repository) {
        this.repository = repository;
    }

    public CompanySupervisor addSupervisor(CompanySupervisor supervisor) {
        return repository.save(supervisor);
    }

    public void deleteSupervisorById(final Long supervisorId) {
        repository.deleteById(supervisorId);
    }

    public List<CompanySupervisor> getAllSupervisors() {
        return repository.findAll();
    }

    public CompanySupervisor getSupervisorById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    public CompanySupervisor updateSupervisor(Long id, CompanySupervisor updatedSupervisor) {

        CompanySupervisor supervisor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supervisor not found"));

        CompanySupervisor updated = supervisor.toBuilder()
                .firstName(updatedSupervisor.getFirstName())
                .lastName(updatedSupervisor.getLastName())
                .email(updatedSupervisor.getEmail())
                .phoneNumber(updatedSupervisor.getPhoneNumber())
                .company(updatedSupervisor.getCompany())
                .build();

        return repository.save(updated);
    }
}