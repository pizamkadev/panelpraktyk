package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contractNumber;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany
    @JoinColumn(name = "contract_id")
    private List<Student> students;

}