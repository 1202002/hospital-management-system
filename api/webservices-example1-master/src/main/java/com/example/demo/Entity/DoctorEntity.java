package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "D_id")
    private Integer id;

    @Column(name = "D_name")
    private String name;

    @Column(name = "Specialty")
    private String specialty;

    @Column(name = "Work_peroid")
    private String workPeriod;
}
