package com.projekt.panelpraktyk.Service;

import com.projekt.panelpraktyk.Repository.KlasyRepository;
import com.projekt.panelpraktyk.models.Klasy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlasyService {
    private final KlasyRepository klasyRepository;

    public KlasyService(KlasyRepository klasyRepository) {
        this.klasyRepository = klasyRepository;
    }

    public List<Klasy> saveAll(List<Klasy> listaKlas) {
        return klasyRepository.saveAll(listaKlas);
    }
}