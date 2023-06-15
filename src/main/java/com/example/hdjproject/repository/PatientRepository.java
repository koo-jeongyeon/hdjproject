package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long>, PatientRepositoryCustom {
    Optional<Patient> findById(Long id);
}
