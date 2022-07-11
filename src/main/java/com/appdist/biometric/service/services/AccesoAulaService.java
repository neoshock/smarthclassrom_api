package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.AccesoAula;
import com.appdist.biometric.service.repositories.AccesoAulaRepository;

@Service
public class AccesoAulaService {
    
    @Autowired
    AccesoAulaRepository accesoAulaRepository;

    public ArrayList<AccesoAula> getAllAccesoAula() {
        return (ArrayList<AccesoAula>) accesoAulaRepository.findAll();
    }

    public AccesoAula getAccesoAulaById(Long id) {
        return accesoAulaRepository.findById(id).get();
    }

    public AccesoAula createAccesoAula(AccesoAula accesoAula) {
        return accesoAulaRepository.save(accesoAula);
    }

    public AccesoAula updateAccesoAula(Long id, AccesoAula accesoAula) {
        accesoAula.setId_acceso_aula(id);
        return accesoAulaRepository.save(accesoAula);
    }

    public void deleteAccesoAula(Long id) {
        accesoAulaRepository.deleteById(id);
    }
}
