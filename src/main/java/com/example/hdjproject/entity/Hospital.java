package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "HOSPITAL")
public class Hospital {
    @Id
    @Column(name = "HOSPITAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 45, nullable = false)
    private String name; //병원명

    @Column(name= "REC_NO", length = 20, nullable = false)
    private String recNo; //요양기관번호

    @Column(name= "LEDGER", length = 10, nullable = false)
    private String ledger; //병원장명
}
