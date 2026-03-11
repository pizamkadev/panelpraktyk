package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Klasy")
public class Klasy {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;
}
