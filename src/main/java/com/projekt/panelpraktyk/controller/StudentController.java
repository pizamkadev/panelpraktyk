package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.models.Referral;
import com.projekt.panelpraktyk.service.StudentService;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/student")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/api/student/{id}")
    public Student getOneStudent(@PathVariable Long id) {
        return studentService.findOne(id);
    }

    @PostMapping("/api/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }
    @PutMapping("/api/student/edit")
    public Student editOne(@RequestParam String name, @RequestParam String lastname, @RequestBody Student student){
        return studentService.updateStudentByName(name, lastname, student);
    }
    @PostMapping("/student/{id}/referral")
    public Referral addReferral(@PathVariable Long id, @RequestBody Referral referral) {
        return studentService.addReferralToStudent(id, referral);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}