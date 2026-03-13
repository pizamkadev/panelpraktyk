package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String studentClass;
    private Long class_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
