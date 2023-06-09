package com.example.clinicaOdontologica.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Dentists")
@Getter @Setter
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "dentist_id")
    private Integer id;
    private String name;
    private String lastName;
    @Setter
    private String license;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Patient> patients = new HashSet<>();


}