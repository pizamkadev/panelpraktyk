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
}
