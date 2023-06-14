package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "HOSPITAL")
public class Hospital {
    @Id
    @Column(name = "HOSPITAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name; //병원명

    @Column(name= "REC_NO")
    private String recNo; //요양기관번호

    @Column(name= "LEDGER")
    private String ledger; //병원장명
}
