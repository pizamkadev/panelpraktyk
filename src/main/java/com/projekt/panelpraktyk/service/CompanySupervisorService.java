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
    public CompanySupervisor updateSupervisor(final Long id, CompanySupervisor updatedSupervisor) {

        CompanySupervisor supervisor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supervisor not found"));

        supervisor.setFirstName(updatedSupervisor.getFirstName());
        supervisor.setLastName(updatedSupervisor.getLastName());
        supervisor.setEmail(updatedSupervisor.getEmail());
        supervisor.setPhoneNumber(updatedSupervisor.getPhoneNumber());
        supervisor.setCompany(updatedSupervisor.getCompany());

        return repository.save(supervisor);
    }
}