package com.projekt.panelpraktyk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String clinicName;
    private String clinicAddress;
    private String harmfulFactors;


    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;
}