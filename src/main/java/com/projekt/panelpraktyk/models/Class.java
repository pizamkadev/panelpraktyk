package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Klasy")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Klasa")
    private String className;

    @Column(name = "LiczbaUczniow")
    private int liczbaUczniow;

    public Class() {
    }
}