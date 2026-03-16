package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}