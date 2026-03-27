package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanySupervisorService;
import com.projekt.panelpraktyk.models.CompanySupervisor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanySupervisorController {

    private final CompanySupervisorService service;

    public CompanySupervisorController(CompanySupervisorService service) {
        this.service = service;
    }

    @PostMapping("/api/addsupervisors")
    public CompanySupervisor addSupervisor(@Valid @RequestBody CompanySupervisor supervisor) {
        return service.addSupervisor(supervisor);
    }

    @GetMapping("/api/supervisors")
    public List<CompanySupervisor> getAllSupervisors() {
        return service.getAllSupervisors();
    }

    @GetMapping("/api/supervisors/{id}")
    public CompanySupervisor getSupervisor(@Valid @PathVariable Long id) {
        return service.getSupervisorById(id);
    }

    @PutMapping("/api/supervisors/{id}")
    public CompanySupervisor updateSupervisor(@PathVariable Long id, @RequestBody CompanySupervisor supervisor) {
        return service.updateSupervisor(id, supervisor);
    }

    @DeleteMapping("/api/supervisors/{id}")
    public String deleteSupervisor(@Valid @PathVariable Long id) {
        service.deleteSupervisorById(id);
        return "Supervisor deleted with id: " + id;
    }

    @PutMapping("/api/supervisor/archive/{id}")
    public CompanySupervisor archiveSupervisor(@PathVariable Long id) {
        return service.archiveSupervisor(id);
    }

    @GetMapping("/api/supervisor/archived")
    public List<CompanySupervisor> getArchivedSupervisors() {
        return service.findAllArchived();
    }
}