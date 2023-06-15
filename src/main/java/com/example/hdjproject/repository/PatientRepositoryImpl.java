package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Patient;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.example.hdjproject.entity.QPatient.patient;

@Repository
@RequiredArgsConstructor
public class PatientRepositoryImpl implements PatientRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Patient> findDynamicQuery(String name, String regNo, String birthday) {
        return queryFactory
                .selectFrom(patient)
                .where(eqName(name),
                        eqRegNo(regNo),
                        eqBirthday(birthday))
                .fetch();
    }

    private BooleanExpression eqName(String name) {
        if(StringUtils.isNullOrEmpty(name)){
            return null;
        }
        return patient.name.eq(name);
    }

    private BooleanExpression eqRegNo(String regNo) {
        if(StringUtils.isNullOrEmpty(regNo)){
            return null;
        }
        return patient.regNo.eq(regNo);
    }

    private BooleanExpression eqBirthday(String birthday) {
        if(StringUtils.isNullOrEmpty(birthday)){
            return null;
        }
        return patient.birthday.eq(birthday);
    }
}
