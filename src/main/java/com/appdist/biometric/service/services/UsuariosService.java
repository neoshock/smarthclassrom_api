package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Usuarios;
import com.appdist.biometric.service.repositories.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;

    public ArrayList<Usuarios> getAllUsuarios() {
        return (ArrayList<Usuarios>) usuariosRepository.findAll();
    }

    public Usuarios getUsuarioById(Long id) {
        return usuariosRepository.findById(id).get();
    }

    public Usuarios createUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }
    
}
