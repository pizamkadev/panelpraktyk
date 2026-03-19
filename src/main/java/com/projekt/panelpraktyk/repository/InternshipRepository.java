package com.projekt.panelpraktyk.repository;


import com.projekt.panelpraktyk.models.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long> {
}