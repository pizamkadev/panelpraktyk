package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Klasy")
@SQLDelete(sql = "UPDATE Klasy SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "Klasa")
    @JsonProperty("className")
    private String className;

    @Column(name = "LiczbaUczniow")
    @JsonProperty("numberOfStudents")
    private int numberOfStudents;

    @OneToMany(cascade = CascadeType.ALL)
    private Boolean isDeleted = false;

    @OneToMany
    @JoinColumn(name = "class_id")
    private List<Student> listStudents;

    public int getNumberOfStudents(){
        return listStudents.size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}