package com.example.demo.Service;

import com.example.demo.Entity.patinetEntity;
import com.example.demo.dto.PatientDTO;

import java.util.List;

public interface patientService {
   List<PatientDTO> getAllPatient() ;
    PatientDTO getPatient(Long id) ;
    PatientDTO creatPatient( patinetEntity pe) ;
    PatientDTO updatePatient(long id , patinetEntity pe);
}
