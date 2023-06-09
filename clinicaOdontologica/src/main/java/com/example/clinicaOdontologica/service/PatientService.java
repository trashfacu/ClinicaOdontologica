package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Patient;
import com.example.clinicaOdontologica.model.PatientDTO;
import com.example.clinicaOdontologica.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements ICRUDService<PatientDTO,Patient>{
    @Autowired
    private IPatientRepository iPatientRepository;
    @Autowired
    ObjectMapper mapper;
    public void create(PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        iPatientRepository.save(patient);
    }

    public PatientDTO read(Long id){
        PatientDTO patientDTO = null;
        Optional<Patient> patient = iPatientRepository.findById(id);
        if (patient.isPresent()){
            patientDTO = mapper.convertValue(patient,PatientDTO.class);
        }
        return patientDTO;
    }

    public void delete(Long id) {
        iPatientRepository.deleteById(id);
    }

    public void update(PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO,Patient.class);
        iPatientRepository.save(patient);
    }

    public List<PatientDTO> getAll(){
        List<Patient> patients = iPatientRepository.findAll();
        List<PatientDTO> patientDTOSList = new ArrayList<>();
        for (Patient patient : patients){
            patientDTOSList.add(mapper.convertValue(patient,PatientDTO.class));
        }
        return patientDTOSList;
    }
}
