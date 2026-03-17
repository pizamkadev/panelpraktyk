package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Positive
    private int phoneNumber;
    private String studentClass;
    @NotNull
    @Positive
    private Long class_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
