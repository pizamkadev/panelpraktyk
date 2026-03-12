package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.StudentService;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService StudentService) {
        this.studentService = StudentService;
    }

    @PostMapping
    public final List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }

    @PutMapping("/edit")
    public Student editOne(@RequestParam String name, @RequestParam String lastname, @RequestBody Student student){
        return studentService.updateStudentByName(name, lastname, student);
    }

}
