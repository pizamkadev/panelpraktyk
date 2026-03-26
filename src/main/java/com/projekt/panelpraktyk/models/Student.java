package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE student SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false AND is_archived = false")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    @Email
    private String email;
    private String phoneNumber;
    private String studentClass;

    private String pesel;
    private LocalDate birthDate;

    @NotNull
    private Long class_id;
    private Boolean isDeleted = false;
    private Boolean isArchived = false;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ReferralMedical> referrals;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getStudentClass() { return studentClass; }

    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }

    public Long getClass_id() { return class_id; }

    public void setClass_id(Long class_id) { this.class_id = class_id; }

    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }
}