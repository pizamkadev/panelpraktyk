package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.ClassService;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/api/allClass")
    public List<Class> getAllClass(){
        return classService.findAll();
    }

    @GetMapping("/api/class/{id}")
    public Class getAllClass(@PathVariable Long id){
        return classService.findOne(id);
    }

    @PostMapping("/api/klasy")
    public List<Class> addMultipleKlasy(@RequestBody List<Class> listClass) {
        return classService.saveAll(listClass);
    }
}