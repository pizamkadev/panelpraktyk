package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.repository.StudentRepository;
import com.projekt.panelpraktyk.repository.ReferralRepository;
import com.projekt.panelpraktyk.models.Student;
import com.projekt.panelpraktyk.models.Referral;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ReferralRepository referralRepository;

    public StudentService(StudentRepository studentRepository, ReferralRepository referralRepository) {
        this.studentRepository = studentRepository;
        this.referralRepository = referralRepository;
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

    @Transactional
    public Referral addReferralToStudent(Long studentId, Referral referral) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono studenta o ID: " + studentId));

        referral.setStudent(student);
        return referralRepository.save(referral);
    }

    @Transactional
    public Student updateStudentByName(String name, String lastname, Student details) {
        Student student = studentRepository.findByNameAndLastname(name, lastname)
                .orElseThrow(() -> new RuntimeException("Student not found: " + name + " " + lastname));

        if (details.getName() != null){
            student.setName(details.getName());
        }

        if (details.getLastname() != null){
            student.setLastname(details.getLastname());
        }

        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}