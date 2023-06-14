package com.example.hdjproject.controller;

import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity postPatient(@RequestBody PatientRegistry patientRegistry){
        ResponseEntity entity = null;

        Patient patient = patientService.create(patientRegistry);

        entity = new ResponseEntity<>(patient, HttpStatus.OK);
        return entity;
    }
}
