package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.repository.StudentRepository;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.studentRepository = StudentRepository;
    }

    public List<Student> saveStudents(List<Student> listStudents) {
        return studentRepository.saveAll(listStudents);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findOne(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudentByName(String name, String lastname, Student details) {
        Student student = studentRepository.findByNameAndLastname(name, lastname).orElseThrow(() -> new RuntimeException("Nie znaleziono studenta: " + name + " " + lastname));

        if (details.getName() != null){
            student.setName(details.getName());
        }

        if (details.getLastname() != null){
            student.setLastname(details.getLastname());
        }

        if (details.getEmail() != null){
            student.setEmail(details.getEmail());
        }

        if (details.getPhoneNumber() >= 1){
            student.setPhoneNumber(details.getPhoneNumber());
        }

        if (details.getStudentClass() != null){
            student.setStudentClass(details.getStudentClass());
        }

        if (details.getCompany() != null) {
            student.setCompany(details.getCompany());
        }

        return studentRepository.save(student);
    }
}
