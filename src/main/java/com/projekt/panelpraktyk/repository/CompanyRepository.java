package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "SELECT * FROM company WHERE is_archived = true AND is_deleted = false", nativeQuery = true)
    List<Company> findAllArchived();
}