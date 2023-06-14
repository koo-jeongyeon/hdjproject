package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CODE")
public class Code {
    @Id
    @Column(name = "CODE_TYPE", length = 10)
    private String codeType; //코드

    @ManyToOne
    @JoinColumn(name = "GROUP_TYPE", nullable = false)
    private CodeGroup groupType; //코드그룹

    @Column(name = "NAME", length = 10, nullable = false)
    private String name; //코드명

}
