package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndLastname(String name, String lastname);
}
