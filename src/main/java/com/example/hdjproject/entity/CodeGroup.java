package com.example.hdjproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CODEGROUP")
public class CodeGroup {
    @Id
    @Column(name = "GROUP_TYPE", length = 10)
    private String groupType; //코드그룹

    @Column(name = "NAME", length = 10, nullable = false)
    private String name; //코드그룹명

    @Column(name = "DESCRIPTION", length = 10, nullable = false)
    private String description; //설명
}
