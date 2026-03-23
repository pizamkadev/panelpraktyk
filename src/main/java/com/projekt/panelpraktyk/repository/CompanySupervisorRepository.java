package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.CompanySupervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanySupervisorRepository extends JpaRepository<CompanySupervisor, Long> {
    @Query(value = "SELECT * FROM company_supervisor WHERE is_archived = true AND is_deleted = false", nativeQuery = true)
    List<CompanySupervisor> findAllArchived();
}