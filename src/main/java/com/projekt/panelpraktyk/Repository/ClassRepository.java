package com.projekt.panelpraktyk.Repository;

import com.projekt.panelpraktyk.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

}