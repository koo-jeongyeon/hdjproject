package com.example.hdjproject.service;

import com.example.hdjproject.entity.Code;
import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.entity.Visit;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.model.PatientResponse;
import com.example.hdjproject.model.PatientUpdate;
import com.example.hdjproject.model.VisitResponse;
import com.example.hdjproject.repository.CodeRepository;
import com.example.hdjproject.repository.HospitalRepository;
import com.example.hdjproject.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;
    private final CodeRepository codeRepository;

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

        Optional<Patient> byIdp = patientRepository.findById(dto.getId());
        Patient patient = byIdp.get();

        patient.updatePatient(dto.getName(),dto.getGenderCode(),dto.getBirthday(),dto.getPhone());

        //병원id 업데이트
        Hospital hospital = patient.getHospital();
        if(hospital.getId() != dto.getHospitalId()){
            Optional<Hospital> byIdh = hospitalRepository.findById(dto.getHospitalId());
            patient.updateHospital(byIdh.get());
        }
        return patient;
    }

    public void delete(Long id){

        Optional<Patient> byId = patientRepository.findById(id);
        Patient patient = byId.get();

        patientRepository.delete(patient);
    }

    public PatientResponse selectOne(Long id){

        Optional<Patient> byIdp = patientRepository.findById(id);
        Patient patient = byIdp.get();

        //성별코드
        Optional<Code> byIdc = codeRepository.findById(patient.getGenderCode());
        String genderCode = byIdc.get().getName();

        List<VisitResponse> visitResponsesList = new ArrayList<>();

        for (Visit visit: patient.getVisits()) {

            //방문상태코드
            Optional<Code> byIdvc = codeRepository.findById(visit.getStateCode());
            String stateCode = byIdvc.get().getName();

            VisitResponse visitResponse = VisitResponse.builder()
                    .hospitalName(visit.getHospital().getName())
                    .createDate(visit.getCreateDate())
                    .state(stateCode)
                    .build();

            visitResponsesList.add(visitResponse);
        }

        PatientResponse patientResponse = PatientResponse.builder()
                .name(patient.getName())
                .regNo(patient.getRegNo())
                .gender(genderCode)
                .birthday(patient.getBirthday())
                .phone(patient.getPhone())
                .visits(visitResponsesList)
                .build();

        return patientResponse;
    }
}
