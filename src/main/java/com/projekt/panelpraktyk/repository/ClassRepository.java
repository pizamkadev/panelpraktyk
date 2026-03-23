package com.projekt.panelpraktyk.repository;

import com.projekt.panelpraktyk.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findByClassName(String className);
    @Query(value = "SELECT * FROM klasy WHERE is_archived = true AND is_deleted = false", nativeQuery = true)
    List<Class> findAllArchived();
}
