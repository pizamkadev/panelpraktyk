package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.ClassService;
import com.projekt.panelpraktyk.models.Class;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/api/class")
    public List<Class> getAllClass() {
        return classService.findAll();
    }

    @GetMapping("/api/class/{id}")
    public Class getAllClass(@PathVariable final Long id) {
        return classService.findClass(id);
    }

    @PatchMapping("/{id}/students")
    public Class addStudentsToClass(@PathVariable final Long id, @RequestBody final List<Student> students) {
        return classService.addStudentsToClass(id, students);
    }

    @PostMapping("/api/class")
    public List<Class> addMultipleKlasy(@RequestBody List<Class> listClass) {
        return classService.saveAll(listClass);
    }

    @PutMapping("/api/class/edit")
    public Class editClass(@RequestParam String className, @RequestBody Class details) {
        return classService.updateClassByName(className, details);
    }

    @DeleteMapping("/api/klasy/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClassById(id);
    }
}