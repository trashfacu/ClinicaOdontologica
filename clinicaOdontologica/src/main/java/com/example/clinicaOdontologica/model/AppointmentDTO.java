package com.example.clinicaOdontologica.model;

import com.example.clinicaOdontologica.entity.Dentist;
import com.example.clinicaOdontologica.entity.Patient;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Dentist dentist;
    private LocalDateTime date;
}
