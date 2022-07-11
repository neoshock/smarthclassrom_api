package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Aula;
import com.appdist.biometric.service.repositories.AulaRepository;

@Service
public class AulaService {
    
    @Autowired
    AulaRepository aulaRepository;

    public ArrayList<Aula> getAllAulas() {
        return (ArrayList<Aula>) aulaRepository.findAll();
    }

    public Aula getAulaById(Long id) {
        return aulaRepository.findById(id).get();
    }

    public Aula createAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Aula updateAula(Long id, Aula aula) {
        aula.setId_aula(id);
        return aulaRepository.save(aula);
    }

    public void deleteAula(Long id) {
        aulaRepository.deleteById(id);
    }
}
