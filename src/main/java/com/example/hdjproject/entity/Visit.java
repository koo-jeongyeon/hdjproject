package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date recDate; //접수일시

    @Column(name = "STATE_CODE")
    private String stateCode; //방문상태코드
}
