package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.ClassService;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/klasy")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public List<Class> addMultipleKlasy(@RequestBody List<Class> listClass) {
        return classService.saveAll(listClass);
    }

    @PutMapping("/edit")
    public Class editClass(@RequestParam String className, @RequestBody Class details) {
        return classService.updateClassByName(className, details);
    }
}
