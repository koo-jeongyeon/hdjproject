package com.example.hdjproject.model;

import com.example.hdjproject.entity.Patient;
import lombok.Data;

@Data
public class PatientRegistry {

    private long hospitalId; //병원id
    private String name; //환자명
    private String genderCode; //성별
    private String birthday; //생년월일
    private String phone; //휴대전화번호

    public Patient toEntity(){
        return Patient.builder()
                .name(name)
                .genderCode(genderCode)
                .birthday(birthday)
                .phone(phone)
                .build();
    }

}
