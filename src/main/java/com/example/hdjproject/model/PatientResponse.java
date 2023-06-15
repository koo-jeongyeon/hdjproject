package com.example.hdjproject.model;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Visit;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PatientResponse {

    private String name; //환자명
    private String regNo; //환자등록번호
    private String gender; //성별
    private String birthday; //생년월일
    private String phone; //휴대전화번호
    private List<VisitResponse> visits; //내원정보

    @Builder
    public PatientResponse(String name, String regNo, String gender, String birthday,
                           String phone, List<VisitResponse> visits){
        this.name = name;
        this.regNo = regNo;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.visits = visits;
    }


}
