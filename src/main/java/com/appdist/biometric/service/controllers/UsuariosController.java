package com.appdist.biometric.service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdist.biometric.service.models.Usuarios;
import com.appdist.biometric.service.services.UsuariosService;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping()
    public ArrayList<Usuarios> getAllUsuarios() {
        try {
            return usuariosService.getAllUsuarios();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Usuarios getUsuarioById(@PathVariable(value = "id") Long id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping()
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        try {
            return usuariosService.createUsuario(usuario);
        } catch (Exception e) {
            usuario.setNombre(e.getMessage());
            return usuario;
        }
    }
}
