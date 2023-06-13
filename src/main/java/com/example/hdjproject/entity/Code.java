package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CODE")
public class Code {
    @Id
    @Column(name = "CODE_TYPE")
    private String codeType; //코드

    @ManyToOne
    @JoinColumn(name = "GROUP_TYPE")
    private CodeGroup groupType; //코드그룹

    @Column(name = "NAME")
    private String name; //코드명

}
