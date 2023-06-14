package com.example.hdjproject.service;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.repository.HospitalRepository;
import com.example.hdjproject.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        patient.setHospital(hospital1Obj);

        //등록번호
        String regNo = getUniqueRegNo(hospitalId);
        patient.setRegNo(regNo);

        return patientRepository.save(patient);
    }

    //고유 병원별 환자등록번호
    //병원별로 중복되지 않도록 (병원id + 날짜)
    public static String getUniqueRegNo(Long hospitalId) {
        String uniqueRegNo = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar dateTime = Calendar.getInstance();
        uniqueRegNo = hospitalId + sdf.format(dateTime.getTime());
        return uniqueRegNo;
    }
}
