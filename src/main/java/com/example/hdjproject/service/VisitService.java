package com.example.hdjproject.service;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.entity.Visit;
import com.example.hdjproject.model.VisitRegistry;
import com.example.hdjproject.repository.HospitalRepository;
import com.example.hdjproject.repository.PatientRepository;
import com.example.hdjproject.repository.VisitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;

    public Visit create(VisitRegistry dto){

        Visit visit = dto.toEntity();

        //병원
        long hospitalId = dto.getHospitalId();
        Optional<Hospital> byIdh = hospitalRepository.findById(hospitalId);
        Hospital hospital = byIdh.get();

        //환자
        long patientId = dto.getPatientId();
        Optional<Patient> byIdp = patientRepository.findById(patientId);
        Patient patient = byIdp.get();

        visit.updateHospital(hospital);
        visit.updatePatient(patient);

        return visitRepository.save(visit);
    }

}
