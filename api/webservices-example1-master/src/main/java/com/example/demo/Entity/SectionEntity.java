package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "section")
public class SectionEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column( name ="S-id")
    private Integer id;

    @Column(name = "S-name")
    private String name;

    @Column(name = "D_id")
    private Integer doctorId;

    // Constructors, getters, and setters
}