package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Dentist;
import com.example.clinicaOdontologica.model.DentistDTO;
import com.example.clinicaOdontologica.repository.IDentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistService implements ICRUDService<DentistDTO, Dentist>{
    @Autowired
    private IDentistRepository DentistRepository;

    @Autowired
    ObjectMapper mapper;

    public void create(DentistDTO dentistDTO){

        Dentist dentist = mapper.convertValue(dentistDTO,Dentist.class);
        DentistRepository.save(dentist);
    }

    public DentistDTO read(Long id){

        DentistDTO dentistDTO = null;
        Optional<Dentist> dentist = DentistRepository.findById(id);
        if (dentist.isPresent()){
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

    public void update(DentistDTO dentistDTO){
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        DentistRepository.save(dentist);
    }

    public void delete(Long id){
        DentistRepository.deleteById(id);
    }

    public List<DentistDTO> getAll(){
        List<Dentist> dentistList = DentistRepository.findAll();
        List<DentistDTO> dentistDTOSet = new ArrayList<>();
        for (Dentist dentist : dentistList){
            dentistDTOSet.add(mapper.convertValue(dentist,DentistDTO.class));
        }
        return dentistDTOSet;
    }

    public Set<DentistDTO> getDentistByLicense(String license){
        Set<Dentist> dentists = DentistRepository.getDentistByLicense(license);
        Set<DentistDTO> dentistDTOSet = new HashSet<>();

        for (Dentist dentist : dentists){
            dentistDTOSet.add(mapper.convertValue(dentist,DentistDTO.class));
        }
        return dentistDTOSet;

    }
}
