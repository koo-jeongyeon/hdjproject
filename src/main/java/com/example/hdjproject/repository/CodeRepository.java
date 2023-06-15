package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code,String> {
    Optional<Code> findById(String id);
}
