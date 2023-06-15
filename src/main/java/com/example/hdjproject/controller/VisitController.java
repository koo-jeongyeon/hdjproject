package com.example.hdjproject.controller;

import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.entity.Visit;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.model.VisitRegistry;
import com.example.hdjproject.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VisitController {

    private final VisitService visitService;

    /*
     * 2023-06-14
     * 환자방문 등록
     */
    @PostMapping("/visit")
    public ResponseEntity postVisit(@RequestBody VisitRegistry request){
        ResponseEntity entity = null;

        Visit visit = visitService.create(request);

        entity = new ResponseEntity<>(visit, HttpStatus.OK);
        return entity;
    }

}
