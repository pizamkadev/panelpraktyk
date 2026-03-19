package com.projekt.panelpraktyk.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE student SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
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
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
