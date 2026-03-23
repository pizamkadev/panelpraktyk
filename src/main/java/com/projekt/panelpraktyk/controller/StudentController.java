package com.projekt.panelpraktyk.controller;

import com.projekt.panelpraktyk.models.Class;
import com.projekt.panelpraktyk.models.Referral;
import com.projekt.panelpraktyk.service.StudentService;
import com.projekt.panelpraktyk.models.Student;
import jakarta.validation.Valid;
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
    public Student getOneStudent(@Valid  @PathVariable Long id) {
        return studentService.findOne(id);
    }

    @PostMapping("/api/addstudents")
    public List<Student> addStudents(@Valid @RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }

    @PutMapping("/api/student/edit")
    public Student editOne(@Valid @RequestParam String name, @Valid @RequestParam String lastname, @Valid @RequestBody Student student){
        return studentService.updateStudentByName(name, lastname, student);
    }

    @PutMapping("/api/student/edit/class")
    public Student editClass(@Valid @RequestParam String name,@Valid @RequestParam String lastname,@Valid @RequestBody Long classId, @RequestBody String className){
        return studentService.updateStudentClassByName(name, lastname, classId, className);
    }

    @PostMapping("/api/student/{id}/referral")
    public Referral addReferral(@Valid @PathVariable Long id, @Valid @RequestBody Referral referral) {
        return studentService.addReferralToStudent(id, referral);
    }
    @DeleteMapping("/api/student/delete/{id}")
    public void deleteStudent(@Valid @PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/api/student/archived")
    public List<Student> getArchivedStudents() {
        return studentService.findAllArchived();
    }

    @PutMapping("/api/student/archive/{id}")
    public Student archiveStudent(@PathVariable Long id) {
        return studentService.archiveStudent(id);
    }

    @PutMapping("/api/student/restore/{id}")
    public Student restoreStudent(@PathVariable Long id) {
        return studentService.restoreFromArchive(id);
    }
}