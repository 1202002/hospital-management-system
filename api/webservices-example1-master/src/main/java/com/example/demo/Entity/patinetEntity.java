package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name ="patient")
public class patinetEntity {



      @Id
      @GeneratedValue
      private Long p_id;

      @Column(name = "P_name")
     private String name ;

      @Column(name="Gender")
     private String Gender;

      @Column(name = "type_diseas")
    private String diseas_name ;

      @Column(name = "p_phone")
    private int phone ;
      @Column(name = "Age")
    private int age ;

}
