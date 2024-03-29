package com.appdist.biometric.service.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import com.appdist.biometric.service.models.Materia;
import com.appdist.biometric.service.models.Usuario;
import com.appdist.biometric.service.models.UsuarioResponse;
import com.appdist.biometric.service.models.request.AuthRequest;
import com.appdist.biometric.service.services.UsuariosService;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping()
    public ResponseEntity<?> getAllUsuarios() {
        try {
            return ResponseEntity.ok(usuariosService.getAllUsuarios());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable(value = "id") Long id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping()
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(usuariosService.createUsuario(usuario));
        } catch (Exception e) {
            usuario.setNombre(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioUpdated = usuariosService.updateUsuario(id, usuario);
            if (usuarioUpdated != null) {
                return ResponseEntity.ok(usuarioUpdated);
            } else {
                return ResponseEntity.badRequest().body("Usuario no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        usuariosService.deleteUsuario(id);
    }

    @GetMapping("/authentication/{id}")
    public ResponseEntity<?> userAuthentication(@PathVariable(value = "id") Integer id) {
        try {
            Object request = usuariosService.userAuthentication(id);
            AuthRequest result = new AuthRequest();
            if (request != null) {
                result.setResult((Object[]) request);

                HashMap requestResult = new HashMap<>();

                requestResult.put("nombre", result.getResult()[0]);
                requestResult.put("acceso_valido", result.getResult()[1]);
                return ResponseEntity.ok(requestResult);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUsuarioByEmail(@PathVariable(value = "email") String email) {
        try {
            Usuario usuario = usuariosService.getUsuarioByEmailUsuario(email);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/authentication/{id}/{state}")
    public ResponseEntity<?> updateUsuarioAuthentication(@PathVariable(value = "id") Long id,
            @PathVariable(value = "state") boolean state) {
        try {
            Usuario usuario = usuariosService.getUsuarioById(id);
            usuario.setUserRegisterFingerprint(state);
            Usuario usuarioUpdated = usuariosService.updateUsuario(id, usuario);
            if (usuarioUpdated != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
