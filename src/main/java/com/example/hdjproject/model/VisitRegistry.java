package com.example.hdjproject.model;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.entity.Visit;
import lombok.Data;

@Data
public class VisitRegistry {

    private long hospitalId; //병원ID
    private long patientId; //환자ID
    private String stateCode; //방문상태코드

    public Visit toEntity(){
        return Visit.builder()
                .stateCode(stateCode)
                .build();
    }

}
