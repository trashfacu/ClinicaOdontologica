package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.Patient;
import com.example.clinicaOdontologica.model.PatientDTO;
import com.example.clinicaOdontologica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO){
        if (patientDTO.getId() != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        patientService.create(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable long id){
        return patientService.read(id);
    }

    @PutMapping
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO){
        patientService.update(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable long id){
        patientService.delete(id);
        return ResponseEntity.status(
                HttpStatus.OK
        ).body("Patient deleted");
    }

    @GetMapping("/list")
    public List<PatientDTO> listPatient(){
        return patientService.getAll();
    }

}

