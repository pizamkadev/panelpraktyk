package com.projekt.panelpraktyk.service;

import com.projekt.panelpraktyk.models.Student;
import com.projekt.panelpraktyk.repository.ClassRepository;
import com.projekt.panelpraktyk.repository.ClassRepository;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> saveAll(final List<Class> listClass) {
        return classRepository.saveAll(listClass);
    }
    public List<Class> findAll(){
        return classRepository.findAll();
    }

    public Class findClass(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class updateClassByName(String className, Class details) {
        Class schoolClass = classRepository.findByClassName(className).orElseThrow(() -> new RuntimeException("Nie znaleziono klasy: " + className));

        if (details.getClassName() != null) {
            schoolClass.setClassName(details.getClassName());
        }

        if (details.getNumberOfStudents() > 0) {
            schoolClass.setNumberOfStudents(details.getNumberOfStudents());
        }


        return classRepository.save(schoolClass);
    }
}