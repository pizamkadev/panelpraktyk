package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.models.Class;
import com.projekt.panelpraktyk.repository.ClassRepository;
import com.projekt.panelpraktyk.models.Student;
import com.projekt.panelpraktyk.repository.ClassRepository;
import com.projekt.panelpraktyk.repository.StudentRepository;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassService {
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    public ClassService(final ClassRepository classRepository, final StudentRepository studentRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    public List<Class> saveAll(final List<Class> listClass) {
        return classRepository.saveAll(listClass);
    }

    public List<Class> findAll() {
        return classRepository.findAll();
    }

    public Class findClass(final Long id) {
        return classRepository.findById(id).orElse(null);
    }
    @Transactional
    public Class addStudentsToClass(final Long classId, final List<Student> students) {

        Class schoolClass = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klasy o ID: " + classId));


        if (schoolClass.getListStudents() == null) {
            schoolClass.setListStudents(new java.util.ArrayList<>());
        }


        for (Student s : students) {
            s.setStudentClass(schoolClass.getClassName());

            s.setId(null);
        }


        schoolClass.getListStudents().addAll(students);
        schoolClass.setNumberOfStudents(schoolClass.getListStudents().size());


        return classRepository.save(schoolClass);
    }

    public Class updateClassByName(final String className, final Class details) {
        final Class schoolClass = classRepository.findByClassName(className)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klasy: " + className));

        if (details.getClassName() != null) {
            schoolClass.setClassName(details.getClassName());
        }

        if (details.calculateNumberOfStudents() > 0) {
            schoolClass.setNumberOfStudents(details.calculateNumberOfStudents());
        }


        return classRepository.save(schoolClass);
    }

    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }
}
