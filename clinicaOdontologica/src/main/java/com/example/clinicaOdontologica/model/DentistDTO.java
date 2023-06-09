package com.example.clinicaOdontologica.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DentistDTO {
    private Long id;
    private String name;
    private String lastName;

}
