package com.projekt.panelpraktyk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String nip;
    private String regon;
    private String krs;
    private String phoneNumber;



    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties("company")
    private List<CompanySupervisor> supervisors;
}