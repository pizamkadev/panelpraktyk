package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.ClassService;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/api/klasy")
    public List<Class> addMultipleKlasy(@RequestBody List<Class> listClass) {
        return classService.saveAll(listClass);
    }
}