package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.service.StudentService;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    private final StudentService StudentService;

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping("/student/{id}")
    public Student getOneStudent(@PathVariable Long id) {
        return studentService.findOne(id);
    @PostMapping
    public final List<Student> addStudents(@RequestBody List<Student> students) {
        return StudentService.saveStudents(students);
    }

    @PostMapping("/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }
    @PutMapping("/edit")
    public Student editOne(@RequestParam String name, @RequestParam String lastname, @RequestBody Student student){
        return studentService.updateStudentByName(name, lastname, student);
        return StudentService.updateStudentByName(name, lastname, student);
    }
}