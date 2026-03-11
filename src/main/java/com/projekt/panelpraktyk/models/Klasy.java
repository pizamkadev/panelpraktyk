package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Klasy")
public class Klasy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Klasa")
    private String klasa;

    @Column(name = "LiczbaUczniow")
    private int liczbaUczniow;

    public Klasy() {
    }

    public Long getId() { return id; }
    public String getKlasa() { return klasa; }
    public int getLiczbaUczniow() { return liczbaUczniow; }

    public void setId(Long id) { this.id = id; }
    public void setKlasa(String klasa) { this.klasa = klasa; }
    public void setLiczbaUczniow(int liczbaUczniow) { this.liczbaUczniow = liczbaUczniow; }
}