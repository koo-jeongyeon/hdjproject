package com.example.hdjproject.service;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.repository.HospitalRepository;
import com.example.hdjproject.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;

    public Patient create(PatientRegistry patientRegistry){

        Patient patient = patientRegistry.toEntity();

        //병원
        long hospitalId = patientRegistry.getHospitalId();
        Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
        Hospital hospital1Obj = hospital.orElse(null);
        patient.updateHospital(hospital1Obj);

        //등록번호
        patient.uniqueRegNo();

        return patientRepository.save(patient);
    }

}
