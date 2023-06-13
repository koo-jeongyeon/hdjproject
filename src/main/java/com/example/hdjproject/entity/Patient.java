package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    @Column(name = "PATIENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
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

}
