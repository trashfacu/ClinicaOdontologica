package com.example.clinicaOdontologica.controller;
import com.example.clinicaOdontologica.model.AppointmentDTO;
import com.example.clinicaOdontologica.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> addAppointment(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.create(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<AppointmentDTO> listAppointment(){
        return appointmentService.getAll();
    }
}
