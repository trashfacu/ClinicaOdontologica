package com.example.clinicaOdontologica.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Residences")
@Getter @Setter
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String addressName;
    private String addressNumber;
    private String city;

}
