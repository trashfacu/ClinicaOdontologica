package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Appointment;
import com.example.clinicaOdontologica.model.AppointmentDTO;
import com.example.clinicaOdontologica.repository.IAppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements ICRUDService<AppointmentDTO,Appointment>{

    @Autowired
    private IAppointmentRepository iAppointmentRepository;
    @Autowired
    ObjectMapper mapper;

    public void create(AppointmentDTO appointmentDTO){
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        iAppointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDTO read(Long id) {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> appointment = iAppointmentRepository.findById(id);
        if (appointment.isPresent()){
            appointmentDTO = mapper.convertValue(appointment,AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void delete(Long id){
        iAppointmentRepository.deleteById(id);
    }

    @Override
    public void update(AppointmentDTO appointmentDTO){
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        iAppointmentRepository.save(appointment);
    }

    public List<AppointmentDTO> getAll(){

        List<Appointment> appointments = iAppointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        for (Appointment appointment : appointments){
            appointmentDTOList.add(mapper.convertValue(appointment,AppointmentDTO.class));
        }
        return appointmentDTOList;
    }

}
