package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.CompanySupervisorService;
import com.projekt.panelpraktyk.models.CompanySupervisor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervisors")
public class CompanySupervisorController {

    private final CompanySupervisorService service;

    public CompanySupervisorController(CompanySupervisorService service) {
        this.service = service;
    }

    @PostMapping
    public CompanySupervisor addSupervisor(@RequestBody CompanySupervisor supervisor) {
        return service.addSupervisor(supervisor);
    }

}
