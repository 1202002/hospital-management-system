package com.example.demo.Repositry;

import com.example.demo.Entity.patinetEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface patientRepo extends JpaRepository<patinetEntity, Long> {

}
