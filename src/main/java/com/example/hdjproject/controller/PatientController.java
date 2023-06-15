package com.example.hdjproject.controller;

import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientListResponse;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.model.PatientResponse;
import com.example.hdjproject.model.PatientUpdate;
import com.example.hdjproject.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    /*
     * 2023-06-15
     * 환자 삭제
     */
    @DeleteMapping("/patient")
    public ResponseEntity deletePatient(@RequestParam long id){
        ResponseEntity entity = null;

        patientService.delete(id);

        entity = new ResponseEntity<>(entity, HttpStatus.OK);
        return entity;
    }
    /*
     * 2023-06-15
     * 환자 조회
     */
    @GetMapping("/patient")
    public ResponseEntity getPatient(@RequestParam long id){
        ResponseEntity entity = null;

        PatientResponse response = patientService.selectOne(id);

        entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }
    /*
     * 2023-06-15
     * 환자 목록 조회
     */
    @GetMapping("/patients")
    public ResponseEntity list(){
        ResponseEntity entity = null;

        List<PatientListResponse> response = patientService.selectList();

        entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }

}
