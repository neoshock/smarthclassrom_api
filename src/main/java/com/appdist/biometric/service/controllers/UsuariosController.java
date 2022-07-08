package com.appdist.biometric.service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdist.biometric.service.models.Authentication;
import com.appdist.biometric.service.models.Usuario;
import com.appdist.biometric.service.services.UsuariosService;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping()
    public ArrayList<Usuario> getAllUsuarios() {
        try {
            return usuariosService.getAllUsuarios();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable(value = "id") Long id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping()
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        try {
            return usuariosService.createUsuario(usuario);
        } catch (Exception e) {
            usuario.setNombre(e.getMessage());
            return usuario;
        }
    }

    @PostMapping("/authentication")
    public boolean userAuthentication(@RequestBody Authentication authentication) {
        return usuariosService.userAuthentication(authentication.getFinger());
    }
}
