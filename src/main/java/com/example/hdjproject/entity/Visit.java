package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "VISIT")
public class Visit {
    @Id
    @Column(name = "VISIT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "HOSPITAL_ID")
    private Hospital hospitalId; //병원ID

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patientId; //환자ID

    @Column(name = "REC_DATE")
    private Date recDate; //접수일시

    @Column(name = "STATE_CODE")
    private String stateCode; //방문상태코드
}
