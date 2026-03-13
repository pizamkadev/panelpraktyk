package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.StudentService;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService StudentService;

    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @PostMapping
    public final List<Student> addStudents(@RequestBody List<Student> students) {
        return StudentService.saveStudents(students);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        StudentService.deleteStudentById(id);
    }


}
