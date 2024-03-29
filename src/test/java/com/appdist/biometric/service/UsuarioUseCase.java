package com.appdist.biometric.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.appdist.biometric.service.models.Authentication;
import com.appdist.biometric.service.models.TipoUsuario;
import com.appdist.biometric.service.models.Usuario;
import com.appdist.biometric.service.services.UsuariosService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioUseCase {
    
    @Autowired
    private UsuariosService usuariosService;

    @Test
    void hasSavedUsuario(){
        Usuario usuario = new Usuario();
        TipoUsuario tipoUsuario = new TipoUsuario();

        usuario.setNombre("Juan");
        usuario.setApellido("Piguabe");
        usuario.setEmail("piguabe@gmail.com");
        usuario.setTelefono("0988848185");
        usuario.setUserRegisterFingerprint(false);
        tipoUsuario.setId(2L);
        //usuario.setTipoUsuario(tipoUsuario);

        Usuario usuarioSaved = usuariosService.createUsuario(usuario);

        assertNotEquals(null, usuarioSaved);
    }

    @Test
    void hasUserAuthenticated(){
        
    }
}
