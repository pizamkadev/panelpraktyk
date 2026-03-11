package com.projekt.panelpraktyk.Controller;

import com.projekt.panelpraktyk.Service.KlasyService;
import com.projekt.panelpraktyk.models.Klasy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.SplittableRandom;

@RestController
public class KlasyController {

    private final KlasyService klasyService;

    public KlasyController(KlasyService klasyService) {
        this.klasyService = klasyService;
    }

    @PostMapping("/api/klasy")
    public List<Klasy> addMultipleKlasy(@RequestBody List<Klasy> listaKlas) {
        return klasyService.saveAll(listaKlas);
    }
}