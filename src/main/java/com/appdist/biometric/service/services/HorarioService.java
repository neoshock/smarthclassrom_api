package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Horario;
import com.appdist.biometric.service.repositories.HorarioRepository;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository horarioRepository;

    public ArrayList<Horario> getAllHorario() {
        return (ArrayList<Horario>) horarioRepository.findAll();
    }

    public Horario getHorarioById(Long id) {
        return horarioRepository.findById(id).get();
    }

    public Horario createHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario updateHorario(Long id, Horario horario) {
        horario.setId(id);
        return horarioRepository.save(horario);
    }

    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}
