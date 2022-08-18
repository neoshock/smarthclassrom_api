package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Usuario;
import com.appdist.biometric.service.repositories.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;

    public ArrayList<Usuario> getAllUsuarios() {
        return (ArrayList<Usuario>) usuariosRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuariosRepository.findById(id).get();
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        usuario.setId_usuario(id);
        return usuariosRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }

    public boolean userAuthentication(String fingerprint) {
        return usuariosRepository.userAuthentication(fingerprint);
    }

    public Usuario getUsuarioByEmailUsuario(String email) {
        return usuariosRepository.getUsuarioByEmail(email);
    }

}
