package com.example.demo.Service;

import com.example.demo.Entity.SectionEntity;
import com.example.demo.Repositry.SectionRepository;
import com.example.demo.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<SectionDTO> getAllSections() {
        List<SectionEntity> sections = sectionRepository.findAll();
        return sections.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SectionDTO getSectionById(Integer id) {
        Optional<SectionEntity> sectionOptional = sectionRepository.findById(id);
        return sectionOptional.map(this::convertToDTO).orElse(null);
    }

    public SectionDTO createSection(SectionDTO sectionDTO) {
        SectionEntity sectionEntity = convertToEntity(sectionDTO);
        SectionEntity createdSection = sectionRepository.save(sectionEntity);
        return convertToDTO(createdSection);
    }

    public SectionDTO updateSection(Integer id, SectionDTO sectionDTO) {
        Optional<SectionEntity> sectionOptional = sectionRepository.findById(id);
        if (sectionOptional.isPresent()) {
            SectionEntity sectionEntity = sectionOptional.get();
            sectionEntity.setName(sectionDTO.getName());
            sectionEntity.setDoctorId(sectionDTO.getDoctorId());
            SectionEntity updatedSection = sectionRepository.save(sectionEntity);
            return convertToDTO(updatedSection);
        } else {
            return null;
        }
    }

    public boolean deleteSection(Integer id) {
        Optional<SectionEntity> sectionOptional = sectionRepository.findById(id);
        if (sectionOptional.isPresent()) {
            sectionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private SectionDTO convertToDTO(SectionEntity sectionEntity) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(sectionEntity.getId());
        sectionDTO.setName(sectionEntity.getName());
        sectionDTO.setDoctorId(sectionEntity.getDoctorId());
        return sectionDTO;
    }

    private SectionEntity convertToEntity(SectionDTO sectionDTO) {
        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setId(sectionDTO.getId());
        sectionEntity.setName(sectionDTO.getName());
        sectionEntity.setDoctorId(sectionDTO.getDoctorId());
        return sectionEntity;
    }
}