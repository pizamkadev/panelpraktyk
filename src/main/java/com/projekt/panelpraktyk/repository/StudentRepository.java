package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.Company;
import com.projekt.panelpraktyk.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndLastname(String name, String lastname);
    @Query(value = "SELECT * FROM student WHERE is_archived = true AND is_deleted = false", nativeQuery = true)
    List<Student> findAllArchived();
    List<Student> findByCompany(Company company);
}
