package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    @Query("FROM Dentist d WHERE d.license = ?1")
    Set<Dentist> getDentistByLicense(String license);
}
