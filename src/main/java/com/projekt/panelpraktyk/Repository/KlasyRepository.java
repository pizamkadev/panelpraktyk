package com.projekt.panelpraktyk.Repository;

import com.projekt.panelpraktyk.models.Klasy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlasyRepository extends JpaRepository<Klasy, Long> {

}