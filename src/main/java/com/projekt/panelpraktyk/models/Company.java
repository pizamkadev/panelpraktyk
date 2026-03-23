package com.projekt.panelpraktyk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE company SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Max(10)
    @NotNull
    private int nip;
    @Max(9)
    @NotNull
    private int regon;
    @Max(10)
    @NotNull
    private int krs;
    @Max(9)
    @NotNull
    private int phoneNumber;

    @Builder.Default
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties("company")
    private List<CompanySupervisor> supervisors;
}