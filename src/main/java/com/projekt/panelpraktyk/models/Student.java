package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String studentClass;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
