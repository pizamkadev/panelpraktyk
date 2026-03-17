package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.StudentService;
import com.projekt.panelpraktyk.models.Student;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getOneStudent(@Valid  @PathVariable Long id) {
        return studentService.findOne(id);
    }

    @PostMapping("/addstudents")
    public List<Student> addStudents(@Valid @RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }
    @PutMapping("/edit")
    public Student editOne(@Valid @RequestParam String name, @Valid @RequestParam String lastname, @Valid @RequestBody Student student){
        return studentService.updateStudentByName(name, lastname, student);
    }
}