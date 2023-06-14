package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CODEGROUP")
public class CodeGroup {
    @Id
    @Column(name = "GROUP_TYPE")
    private String groupType; //코드그룹

    @Column(name = "NAME")
    private String name; //코드그룹명

    @Column(name = "DESCRIPTION")
    private String description; //설명
}
