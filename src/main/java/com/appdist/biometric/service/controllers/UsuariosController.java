package com.appdist.biometric.service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
        try {
            return usuariosService.updateUsuario(id, usuario);
        } catch (Exception e) {
            usuario.setNombre(e.getMessage());
            return usuario;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        usuariosService.deleteUsuario(id);
    }

    @PostMapping("/authentication")
    public boolean userAuthentication(@RequestBody Authentication authentication) {
        return usuariosService.userAuthentication(authentication.getFinger());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUsuarioByEmail(@PathVariable(value = "email") String email) {
        try {
            if (usuariosService.getUsuarioByEmailUsuario(email) != null) {
                return ResponseEntity.ok(usuariosService.getUsuarioByEmailUsuario(email));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
