package com.projekt.panelpraktyk.Service;

import com.projekt.panelpraktyk.Repository.ClassRepository;
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
}