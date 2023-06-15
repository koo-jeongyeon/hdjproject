package com.example.hdjproject.model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitResponse {

    private String hospitalName;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

    private String state;

    @Builder
    public VisitResponse(String hospitalName, LocalDateTime createDate, String state){
        this.hospitalName = hospitalName;
        this.createDate = createDate;
        this.state = state;
    }
}
