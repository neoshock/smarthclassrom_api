package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Materias;
import com.appdist.biometric.service.repositories.MateriasRepository;

@Service
public class MateriasService {
    
    @Autowired
    MateriasRepository materiasRepository;

    public ArrayList<Materias> getAllMaterias() {
        return (ArrayList<Materias>) materiasRepository.findAll();
    }

    public Materias getMateriaById(Long id) {
        return materiasRepository.findById(id).get();
    }

    public Materias createMateria(Materias materia) {
        return materiasRepository.save(materia);
    }
    
}
