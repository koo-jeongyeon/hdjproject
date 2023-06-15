package com.example.hdjproject.controller;

import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.model.PatientUpdate;
import com.example.hdjproject.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PatientController {

    private final PatientService patientService;

    /*
     * 2023-06-14
     * 환자 등록
     */
    @PostMapping("/patient")
    public ResponseEntity postPatient(@RequestBody PatientRegistry request){
        ResponseEntity entity = null;

        Patient patient = patientService.create(request);

        entity = new ResponseEntity<>(patient, HttpStatus.OK);
        return entity;
    }
    /*
     * 2023-06-15
     * 환자 수정
     */
    @PutMapping("/patient")
    public ResponseEntity putPatient(@RequestBody PatientUpdate request){
        ResponseEntity entity = null;

        Patient patient = patientService.update(request);

        entity = new ResponseEntity<>(patient, HttpStatus.OK);
        return entity;
    }
}
