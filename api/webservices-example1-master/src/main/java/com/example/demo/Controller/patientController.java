package com.example.demo.Controller;

import com.example.demo.Entity.patinetEntity;
import com.example.demo.Service.patientServiceImp;
import com.example.demo.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ap1-v1/patient")
public class patientController {

    @Autowired
    private final patientServiceImp patientService;

    public patientController(patientServiceImp patientService) {
        this.patientService = patientService;
    }
    // get all patient.
    @GetMapping("/getAll")
    public List<PatientDTO> getPatient() {
        return patientService.getAllPatient();
    }


    //get patient by id
    @GetMapping("/get/{id}")
    public PatientDTO getPatient_id(@PathVariable("id") Long id){

         return patientService.getPatient(id) ;

    }

    // creat Patient
    @PostMapping
    public PatientDTO creatPatient(@RequestBody patinetEntity patientEnt){

        return patientService.creatPatient(patientEnt);
    }


//    update the patient.
    @PutMapping("/update/{id}")
    public PatientDTO updatePatient(@PathVariable("id") Long id , @RequestBody patinetEntity pe){

      return  patientService.updatePatient(id ,pe) ;

    }

//    Delete patient.

    @DeleteMapping("/deletePatient/{id}")
    public void deletePatient(@PathVariable("id") Long id){

           patientService.dele_patient(id);

    }

}