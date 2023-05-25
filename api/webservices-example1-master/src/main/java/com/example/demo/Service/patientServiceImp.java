package com.example.demo.Service;

import com.example.demo.Entity.patinetEntity;
import com.example.demo.Repositry.patientRepo;
import com.example.demo.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class patientServiceImp implements patientService {

    private patientRepo patientRepository;

    @Autowired
    public patientServiceImp(patientRepo patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDTO> getAllPatient() {
      System.out.println(patientRepository.findAll().indexOf(0));
        List<patinetEntity> ppp = new ArrayList<patinetEntity>();
        patinetEntity p1 = new patinetEntity();

        p1.setName("Abdalkareem");

        p1.setGender("male");
        ppp.add(p1);


        List<patinetEntity> pe = patientRepository.findAll();

      List<PatientDTO> ps1 = convertToDTOList(pe) ;
        return ps1 ;

    }

    public PatientDTO getPatient(Long id) {

        patinetEntity patient = patientRepository.findById(id).orElse(null);
        if (patient != null) {
            return convertToDTO(patient);
        }
        return null;
    }

    // creat Patient.
    public PatientDTO creatPatient( patinetEntity pe) {
        patinetEntity patient = pe ;
        patinetEntity createdPatient = patientRepository.save(patient);
        return convertToDTO(createdPatient);
    }
    private PatientDTO convertToDTO(patinetEntity patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getP_id());
        patientDTO.setName(patient.getName());
        patientDTO.setGender(patient.getGender());
        patientDTO.setDiseas_name(patient.getDiseas_name());
        patientDTO.setPhone(String.valueOf(patient.getPhone()));
        patientDTO.setAge(patient.getAge());
        return patientDTO;
    }
//
    private patinetEntity convertToEntity(PatientDTO patientDTO) {
        patinetEntity patient = new patinetEntity();
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setDiseas_name(patientDTO.getDiseas_name());
        patient.setPhone(Integer.parseInt(patientDTO.getPhone()));
        patient.setAge(patientDTO.getAge());
        return patient;
    }

    private List<PatientDTO> convertToDTOList(List<patinetEntity> patients) {
        return patients.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


//    update the patient.
   public PatientDTO updatePatient(long id , patinetEntity pe) {
      patinetEntity existingPatient = patientRepository.findById(id).orElse(null);
       if (existingPatient != null) {
          patinetEntity patient = pe ;
            existingPatient.setName(patient.getName());
            patientRepository.save(existingPatient);
//            patientRepository.oK(existingPatient);
           PatientDTO o = new PatientDTO();
           o.setName("Jamal");
            return null ;
    }
    return null;
}

//delete patient
     public void dele_patient(Long id){

        patinetEntity pa = patientRepository.findById(id).orElse(null);
        if(pa != null){
             patientRepository.deleteById(id);
        }
     }

    }

