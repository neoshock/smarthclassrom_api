package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Materia;
import com.appdist.biometric.service.repositories.MateriasRepository;

@Service
public class MateriasService {
    
    @Autowired
    MateriasRepository materiasRepository;

    public ArrayList<Materia> getAllMaterias() {
        return (ArrayList<Materia>) materiasRepository.findAll();
    }

    public Materia getMateriaById(Long id) {
        return materiasRepository.findById(id).get();
    }

    public Materia createMateria(Materia materia) {
        return materiasRepository.save(materia);
    }

    public Materia updateMateria(Long id, Materia materia) {
        materia.setId(id);
        return materiasRepository.save(materia);
    }

    public void deleteMateria(Long id) {
        materiasRepository.deleteById(id);
    }

    public ArrayList<Materia> getMateriasByEmail(String email) {
        return materiasRepository.getMateriasByEmail(email);
    }
    
}
