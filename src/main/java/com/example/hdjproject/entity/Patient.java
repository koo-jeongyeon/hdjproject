package com.example.hdjproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "HOSPITAL_ID", nullable = false)
    private Hospital hospital;

    @Column(name = "NAME", length = 45, nullable = false)
    private String name; //환자명

    @Column(name = "REG_NO", length = 13, nullable = false)
    private String regNo; //환자등록번호

    @Column(name = "GENDER_CODE", length = 10, nullable = false)
    private String genderCode; //성별코드

    @Column(name = "BIRTHDAY", length = 10)
    private String birthday; //생년월일

    @Column(name = "PHONE", length = 20)
    private String phone; //휴대전화번호

    @Builder
    public Patient(String name, String genderCode, String birthday, String phone){
        this.name = name;
        this.genderCode = genderCode;
        this.birthday = birthday;
        this.phone = phone;
    }

    public void updatePatient(String name, String genderCode, String birthday, String phone){
        this.name = name;
        this.genderCode = genderCode;
        this.birthday = birthday;
        this.phone = phone;
    }

    public void updateHospital(Hospital hospital){
        this.hospital = hospital;
    }

    //고유 병원별 환자등록번호
    //병원별로 중복되지 않도록 (UTC시간 밀리세컨드 10자리 + 랜덤3자리값)
    public void uniqueRegNo() {
        String millis = (System.currentTimeMillis() + "").substring(0,10);
        int randomNum = (int) (Math.random() * 899) + 100;// 100~999의 범위 중 랜덤
        regNo = millis + randomNum;
    }
}
