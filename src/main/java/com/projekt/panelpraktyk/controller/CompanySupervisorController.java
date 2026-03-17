package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanySupervisorService;
import com.projekt.panelpraktyk.models.CompanySupervisor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisors")
public class CompanySupervisorController {

    private final CompanySupervisorService service;

    public CompanySupervisorController(CompanySupervisorService service) {
        this.service = service;
    }

    @PostMapping
    public CompanySupervisor addSupervisor(@Valid @RequestBody CompanySupervisor supervisor) {
        return service.addSupervisor(supervisor);
    }

    @GetMapping
    public List<CompanySupervisor> getAllSupervisors() {
        return service.getAllSupervisors();
    }
    @GetMapping("/{id}")
    public CompanySupervisor getSupervisor(@Valid @PathVariable Long id) {
        return service.getSupervisorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSupervisor(@Valid @PathVariable Long id) {
        service.deleteSupervisorById(id);
        return "Supervisor deleted with id: " + id;
    }
}