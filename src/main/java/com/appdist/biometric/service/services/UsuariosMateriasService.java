package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.UsuariosMaterias;
import com.appdist.biometric.service.repositories.UsuariosMateriaRepository;

@Service
public class UsuariosMateriasService {
    @Autowired
    UsuariosMateriaRepository usuariosMateriaRepository;

    public ArrayList<UsuariosMaterias> getAllUsuariosMaterias() {
        return (ArrayList<UsuariosMaterias>) usuariosMateriaRepository.findAll();
    }

    public UsuariosMaterias getUsuariosMateriasById(Long id) {
        return usuariosMateriaRepository.findById(id).get();
    }

    public UsuariosMaterias createUsuariosMaterias(UsuariosMaterias usuariosMaterias) {
        return usuariosMateriaRepository.save(usuariosMaterias);
    }
}
