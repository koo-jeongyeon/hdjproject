package com.example.hdjproject.repository;

import com.example.hdjproject.entity.Hospital;
import com.example.hdjproject.entity.Patient;
import com.example.hdjproject.model.PatientRegistry;
import com.example.hdjproject.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2023-06-16
 * 동적검색(querydsl)에 대한 테스트코드 작성
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientRepositoryImplTest {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;

    @Test
    public void DynamicQuery(){
        //given
        String targetname = "테스트";

        patientService.create(new PatientRegistry(1,"테스트","F","",""));
        patientService.create(new PatientRegistry(1,"테스트2","F","",""));
        patientService.create(new PatientRegistry(1,"테스트3","F","",""));

        //when
        List<Patient> patients = patientRepository.findDynamicQuery(targetname,"","");

        //then
        assertThat(patients).hasSize(1);
        assertThat(patients.get(0).getName()).isEqualTo("테스트");
    }
}
