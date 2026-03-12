package com.projekt.panelpraktyk.Controller;

import com.projekt.panelpraktyk.Service.ClassService;
import com.projekt.panelpraktyk.models.Class;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService klasyService) {
        this.classService = klasyService;
    }

    @PostMapping("/api/klasy")
    public List<Class> addMultipleKlasy(@RequestBody List<Class> listaKlas) {
        return classService.saveAll(listaKlas);
    }
}