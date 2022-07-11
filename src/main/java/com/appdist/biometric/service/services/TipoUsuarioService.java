package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.TipoUsuario;
import com.appdist.biometric.service.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    public ArrayList<TipoUsuario> getAllTipoUsuarios() {
        return (ArrayList<TipoUsuario>) tipoUsuarioRepository.findAll();
    }

    public TipoUsuario getTipoUsuarioById(Long id) {
        return tipoUsuarioRepository.findById(id).get();
    }

    public TipoUsuario createTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public TipoUsuario updateTipoUsuario(Long id, TipoUsuario tipoUsuario) {
        tipoUsuario.setIdTipoUsuario(id);
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void deleteTipoUsuario(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
