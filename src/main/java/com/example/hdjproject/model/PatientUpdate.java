package com.example.hdjproject.model;

import lombok.Data;

@Data
public class PatientUpdate {

    private long id;
    private long hospitalId; //병원id
    private String name; //환자명
    private String genderCode; //성별
    private String birthday; //생년월일
    private String phone; //휴대전화번호
}
