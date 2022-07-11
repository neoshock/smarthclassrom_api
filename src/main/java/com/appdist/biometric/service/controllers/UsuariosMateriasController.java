package com.appdist.biometric.service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdist.biometric.service.models.UsuariosMaterias;
import com.appdist.biometric.service.services.UsuariosMateriasService;

@RestController
@RequestMapping("api/usuarios-materias")
public class UsuariosMateriasController {
    @Autowired
    UsuariosMateriasService usuariosMateriasService;

    @GetMapping()
    public ArrayList<UsuariosMaterias> getAllUsuariosMaterias() {
        return usuariosMateriasService.getAllUsuariosMaterias();
    }

    @GetMapping("/{id}")
    public UsuariosMaterias getUsuariosMateriasById(@PathVariable(value = "id") Long id) {
        return usuariosMateriasService.getUsuariosMateriasById(id);
    }

    @PostMapping()
    public UsuariosMaterias createUsuariosMaterias(@RequestBody UsuariosMaterias usuariosMaterias) {
        try {
            return usuariosMateriasService.createUsuariosMaterias(usuariosMaterias);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public UsuariosMaterias updateUsuariosMaterias(@PathVariable(value = "id") Long id,
            @RequestBody UsuariosMaterias usuariosMaterias) {
        try {
            return usuariosMateriasService.updateUsuariosMaterias(id, usuariosMaterias);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuariosMaterias(@PathVariable(value = "id") Long id) {
        usuariosMateriasService.deleteUsuariosMaterias(id);
    }
}
