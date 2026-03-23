package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Klasy")
@SQLDelete(sql = "UPDATE Klasy SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @NotNull
    @Positive
    private Long id;

    @Column(name = "Klasa")
    @JsonProperty("className")
    @NotBlank
    private String className;

    @Column(name = "LiczbaUczniow")
    @JsonProperty("numberOfStudents")
    @Min(1)
    @Max(30)
    @Positive
    private int numberOfStudents;

    @OneToMany(cascade = CascadeType.ALL)
    private Boolean isDeleted = false;

    @OneToMany
    @JoinColumn(name = "class_id")
    private List<Student> listStudents;

    public int getNumberOfStudents(){
        return listStudents.size();
    }
}