package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
