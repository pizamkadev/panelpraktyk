package com.projekt.panelpraktyk.Service;

import com.projekt.panelpraktyk.Repository.ClassRepository;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository klasyRepository) {
        this.classRepository = klasyRepository;
    }

    public List<Class> saveAll(final List<Class> listaKlas) {
        return classRepository.saveAll(listaKlas);
    }
}