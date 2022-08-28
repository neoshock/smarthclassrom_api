package com.appdist.biometric.service.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Usuario;
import com.appdist.biometric.service.models.request.AuthRequest;
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
        usuario.setId(id);
        return usuariosRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }

    public Object userAuthentication(Integer uid) {
        return usuariosRepository.userAuthentication(uid);
    }

    public Usuario getUsuarioByEmailUsuario(String email) {
        return usuariosRepository.getUsuarioByEmail(email);
    }

}
