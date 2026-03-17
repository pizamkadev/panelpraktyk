package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referralNumber;
    private LocalDate issueDate;
    private String position;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}