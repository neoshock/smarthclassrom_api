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

import com.appdist.biometric.service.models.TipoUsuario;
import com.appdist.biometric.service.services.TipoUsuarioService;

@RestController
@RequestMapping("api/tipo-usuario")
public class TipoUsuarioController {
    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @GetMapping()
    public ArrayList<TipoUsuario> getAllTipoUsuarios() {
        return tipoUsuarioService.getAllTipoUsuarios();
    }

    @GetMapping("/{id}")
    public TipoUsuario getTipoUsuarioById(@PathVariable(value = "id") Long id) {
        return tipoUsuarioService.getTipoUsuarioById(id);
    }

    @PostMapping()
    public TipoUsuario createTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        try {
            return tipoUsuarioService.createTipoUsuario(tipoUsuario);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public TipoUsuario updateTipoUsuario(@PathVariable(value = "id") Long id, @RequestBody TipoUsuario tipoUsuario) {
        try {
            return tipoUsuarioService.updateTipoUsuario(id, tipoUsuario);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTipoUsuario(@PathVariable(value = "id") Long id) {
        tipoUsuarioService.deleteTipoUsuario(id);
    }
}
