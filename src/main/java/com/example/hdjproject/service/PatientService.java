package com.example.hdjproject.service;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.model.PatientUpdate;
import com.example.hdjproject.repository.HospitalRepository;
import com.example.hdjproject.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;

    public Patient create(PatientRegistry dto){

        Patient patient = dto.toEntity();

        //병원
        long hospitalId = dto.getHospitalId();
        Optional<Hospital> byId = hospitalRepository.findById(hospitalId);
        Hospital hospital = byId.get();
        patient.updateHospital(hospital);

        //등록번호
        patient.uniqueRegNo();

        return patientRepository.save(patient);
    }

    public Patient update(PatientUpdate dto){

        Optional<Patient> byId = patientRepository.findById(dto.getId());
        Patient patient = byId.get();

        patient.updatePatient(dto.getName(),dto.getGenderCode(),dto.getBirthday(),dto.getPhone());

        //병원id 업데이트
        Hospital hospital = patient.getHospital();
        if(hospital.getId() != dto.getHospitalId()){
            Optional<Hospital> byId2 = hospitalRepository.findById(dto.getHospitalId());
            patient.updateHospital(byId2.get());
        }
        return patient;
    }
}
