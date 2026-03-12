package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanySupervisorService;
import com.projekt.panelpraktyk.models.CompanySupervisor;
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
    public CompanySupervisor addSupervisor(@RequestBody CompanySupervisor supervisor) {
        return service.addSupervisor(supervisor);
    }

    @GetMapping
    public List<CompanySupervisor> getAllSupervisors() {
        return service.getAllSupervisors();
    }

    @GetMapping("/{id}")
    public CompanySupervisor getSupervisor(@PathVariable Long id) {
        return service.getSupervisorById(id);
    }
}