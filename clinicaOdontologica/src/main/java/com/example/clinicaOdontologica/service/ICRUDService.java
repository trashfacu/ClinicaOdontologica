package com.example.clinicaOdontologica.service;

import java.util.List;

public interface ICRUDService <DTO, Class> {
    void create(DTO Class) throws Exception;
    DTO read(Long id) throws Exception;
    void delete(Long id) throws Exception;
    void update(DTO Class) throws Exception;
    List<DTO> getAll();
}
