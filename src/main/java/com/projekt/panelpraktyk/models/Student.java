package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List; // Nie zapomnij o imporcie!

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Referral> referrals;
}