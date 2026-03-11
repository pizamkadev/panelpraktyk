package com.projekt.panelpraktyk.Service;

import com.projekt.panelpraktyk.Repository.StudentRepository;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository StudentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    public List<Student> zapiszUczniow(List<Student> listaUczniow) {
        return StudentRepository.saveAll(listaUczniow);
    }



}
