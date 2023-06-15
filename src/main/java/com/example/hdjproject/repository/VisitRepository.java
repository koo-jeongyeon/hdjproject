package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit,Long> {
    Optional<Visit> findById(Long id);
}
