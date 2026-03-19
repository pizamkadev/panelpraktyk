package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReferralRepository extends JpaRepository<Referral, Long> {
}