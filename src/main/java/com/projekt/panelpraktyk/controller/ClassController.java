package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.ClassService;
import com.projekt.panelpraktyk.models.Class;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/api/class")
    public List<Class> getAllClass(){
        return classService.findAll();
    }

    @GetMapping("/api/class/{id}")
    public Class getClass(@Valid @PathVariable Long id){
        return classService.findClass(id);
    }

    @PostMapping("/api/class/add")
    public List<Class> addMultipleKlasy(@Valid @RequestBody List<Class> listClass) {
        return classService.saveAll(listClass);
    }

    @PutMapping("/edit")
    public Class editClass(@Valid @RequestParam String className,@Valid @RequestBody Class details) {
        return classService.updateClassByName(className, details);
    }
}
