package com.example.demo.Service;

import com.example.demo.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> getAllDoctors();
    DoctorDto getDoctorById(Integer id);
    DoctorDto createDoctor(DoctorDto doctorDto);
    DoctorDto updateDoctor(Integer id, DoctorDto doctorDto);
    boolean deleteDoctor(Integer id);
}
