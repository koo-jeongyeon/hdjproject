package com.example.hdjproject.model;

import com.example.hdjproject.entity.Patient;
import lombok.Builder;
import lombok.Data;

@Data
public class PatientRegistry {

    private long hospitalId; //병원id
    private String name; //환자명
    private String genderCode; //성별
    private String birthday; //생년월일
    private String phone; //휴대전화번호

    @Builder
    public PatientRegistry(long hospitalId, String name, String genderCode, String birthday, String phone){
        this.hospitalId = hospitalId;
        this.name = name;
        this.genderCode = genderCode;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Patient toEntity(){
        return Patient.builder()
                .name(name)
                .genderCode(genderCode)
                .birthday(birthday)
                .phone(phone)
                .build();
    }

}
