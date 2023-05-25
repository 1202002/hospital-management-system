package com.example.demo.Service;

import com.example.demo.Entity.DoctorEntity;
import com.example.demo.Repositry.DoctorRepository;
import com.example.demo.dto.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<DoctorEntity> doctors = doctorRepository.findAll();
        return convertToDtoList(doctors);
    }

    @Override
    public DoctorDto getDoctorById(Integer id) {
        Optional<DoctorEntity> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            DoctorEntity doctor = doctorOptional.get();
            return convertToDto(doctor);
        }
        return null;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        DoctorEntity doctor = convertToEntity(doctorDto);
        DoctorEntity savedDoctor = doctorRepository.save(doctor);
        return convertToDto(savedDoctor);
    }

    @Override
    public DoctorDto updateDoctor(Integer id, DoctorDto doctorDto) {
        Optional<DoctorEntity> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            DoctorEntity doctor = doctorOptional.get();
            doctor.setName(doctorDto.getName());
            doctor.setSpecialty(doctorDto.getSpecialty());
            doctor.setWorkPeriod(doctorDto.getWorkPeriod());
            DoctorEntity updatedDoctor = doctorRepository.save(doctor);
            return convertToDto(updatedDoctor);
        }
        return null;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
        return false;
    }

    private DoctorDto convertToDto(DoctorEntity doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialty(doctor.getSpecialty());
        doctorDto.setWorkPeriod(doctor.getWorkPeriod());
        return doctorDto;
    }

    private DoctorEntity convertToEntity(DoctorDto doctorDto) {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setName(doctorDto.getName());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setWorkPeriod(doctorDto.getWorkPeriod());
        return doctor;
    }

    private List<DoctorDto> convertToDtoList(List<DoctorEntity> doctors) {
        return doctors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}