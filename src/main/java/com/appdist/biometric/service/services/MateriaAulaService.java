package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.MateriaAula;
import com.appdist.biometric.service.repositories.MateriaAulaRepository;

@Service
public class MateriaAulaService {
    
    @Autowired
    MateriaAulaRepository materiaAulaRepository;

    public ArrayList<MateriaAula> getAllMateriaAula() {
        return (ArrayList<MateriaAula>) materiaAulaRepository.findAll();
    }

    public MateriaAula getMateriaAulaById(Long id) {
        return materiaAulaRepository.findById(id).get();
    }

    public MateriaAula createMateriaAula(MateriaAula materiaAula) {
        return materiaAulaRepository.save(materiaAula);
    }

    public MateriaAula updateMateriaAula(Long id, MateriaAula materiaAula) {
        materiaAula.setId_materia_aula(id);
        return materiaAulaRepository.save(materiaAula);
    }

    public void deleteMateriaAula(Long id) {
        materiaAulaRepository.deleteById(id);
    }
}
