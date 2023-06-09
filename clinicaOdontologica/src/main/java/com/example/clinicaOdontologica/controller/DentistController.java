package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.DentistDTO;
import com.example.clinicaOdontologica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @PostMapping
    public ResponseEntity<?> addDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.create(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDTO getDentist(@PathVariable long id){
        return dentistService.read(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.update(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable long id) {
        dentistService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dentist deleted!");
    }

    @GetMapping("/list")
    public List<DentistDTO> listDentist(){
        return dentistService.getAll();
    }

    @GetMapping("/ListByLicense")
    public Set<DentistDTO> listDentistByLicense (@RequestParam String license){
        return dentistService.getDentistByLicense(license);
    }


}
