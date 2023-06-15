package com.example.hdjproject.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class PatientListResponse {

    private String name; //환자명
    private String regNo; //환자등록번호
    private String gender; //성별
    private String birthday; //생년월일
    private String phone; //휴대전화번호
    private LocalDateTime createDate; //최근방문

    @Builder
    public PatientListResponse(String name, String regNo, String gender, String birthday,
                               String phone, LocalDateTime createDate){
        this.name = name;
        this.regNo = regNo;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.createDate = createDate;
    }

    public void updateCreateDateFormat(String format){
        DateTimeFormatter.ofPattern(format).format(createDate);
    }
}
