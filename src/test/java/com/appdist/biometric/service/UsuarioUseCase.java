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
        usuario.setApellido("Perez");
        usuario.setEmail("pideun@gmail.com");
        usuario.setFingerprint("U}CY,aWJe8LG9ar,}6z!BpZdH$Aa[jQ,mwZCRU@gUx:cd-X)-atp8C?k?Gp8:#nTt5Uem4ydNQGRU!%GrY]-kRgrgEij4x]/_M==");
        usuario.setTelefono("0988848185");
        tipoUsuario.setIdTipoUsuario(1L);
        usuario.setTipoUsuario(tipoUsuario);

        Usuario usuarioSaved = usuariosService.createUsuario(usuario);

        assertNotEquals(null, usuarioSaved);
    }

    @Test
    void hasUserAuthenticated(){
        Authentication authentication = new Authentication();
        authentication.setFinger("9u@S+]r!);Pnkyp4gtC8{L5Qw(A]*K");
        boolean isAuthenticated = usuariosService.userAuthentication(authentication.getFinger());
        assertNotEquals(false, isAuthenticated);
    }
}
