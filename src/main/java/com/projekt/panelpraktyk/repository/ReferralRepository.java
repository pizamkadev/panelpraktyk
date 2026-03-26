package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.ReferralMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReferralRepository extends JpaRepository<ReferralMedical, Long> {
    List<ReferralMedical> findAllByStudentId(Long studentId);
}