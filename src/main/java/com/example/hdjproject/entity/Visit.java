package com.example.hdjproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "VISIT")
public class Visit {
    @Id
    @Column(name = "VISIT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "HOSPITAL_ID", nullable = false)
    private Hospital hospital; //병원ID

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", nullable = false)
    private Patient patient; //환자ID

    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private LocalDateTime createDate; //접수일시

    @Column(name = "STATE_CODE", length = 10, nullable = false)
    private String stateCode; //방문상태코드

    @Builder
    public Visit(String stateCode){
        this.stateCode = stateCode;
    }

    public void updateHospital(Hospital hospital){
        this.hospital = hospital;
    }

    public void updatePatient(Patient patient){
        this.patient = patient;
    }

    public void updateStateCode(String stateCode){
        this.stateCode = stateCode;
    }

}
