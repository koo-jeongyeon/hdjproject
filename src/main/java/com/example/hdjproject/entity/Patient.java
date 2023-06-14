package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PATIENT")
public class Patient {
    @Id
    @Column(name = "PATIENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITAL_ID")
    private Hospital hospital;

    @Column(name = "NAME")
    private String name; //환자명

    @Column(name = "REG_NO")
    private String regNo; //환자등록번호

    @Column(name = "GENDER_CODE")
    private String genderCode; //성별코드

    @Column(name = "BIRTHDAY")
    private String birthday; //생년월일

    @Column(name = "PHONE")
    private String phone; //휴대전화번호

    @Builder
    public Patient(String name, String regNo, String genderCode, String birthday, String phone){
        this.name = name;
        this.regNo = regNo;
        this.genderCode = genderCode;
        this.birthday = birthday;
        this.phone = phone;
    }

    public void updateHospital(Hospital hospital){
        this.hospital = hospital;
    }

    //고유 병원별 환자등록번호
    //병원별로 중복되지 않도록 (병원id + 날짜)
    public void uniqueRegNo() {
        String uniqueRegNo = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar dateTime = Calendar.getInstance();
        regNo = hospital.getId() + sdf.format(dateTime.getTime());
    }
}
