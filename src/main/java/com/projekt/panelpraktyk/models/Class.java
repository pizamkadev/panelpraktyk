package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Klasy")
@SQLDelete(sql = "UPDATE Klasy SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false AND is_archived = false")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
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
    private int numberOfStudents;

    private Boolean isDeleted = false;
    private Boolean isArchived = false;

    @OneToMany
    @JoinColumn(name = "class_id")
    private List<Student> listStudents = new ArrayList<>();

    public int calculateNumberOfStudents() {
        return listStudents.size();
    }
}