package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
