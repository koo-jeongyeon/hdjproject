package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Patient;

import java.util.List;

public interface PatientRepositoryCustom {

    List<Patient> findDynamicQuery(String name, String regNo, String birthday);
}
