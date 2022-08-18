package com.appdist.biometric.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appdist.biometric.service.models.TipoUsuario;
import com.appdist.biometric.service.services.TipoUsuarioService;

@SpringBootTest
public class TipoUsuarioUseCase {
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @Test
    void hasSavedTipoUsuario() {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNombre("Alumno");
        tipoUsuario.setDescripcion("Alumno de la Universidad");
        tipoUsuario.setIdTipoUsuario(1L);
        TipoUsuario tipoUsuarioSaved = tipoUsuarioService.createTipoUsuario(tipoUsuario);
        
        assertNotEquals(null, tipoUsuarioSaved);
    }

    @Test
    void hasUpdatedTipoUsuario() {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNombre("Alumno");
        tipoUsuario.setDescripcion("Alumno de la Universidad");
        tipoUsuario.setIdTipoUsuario(1L);
        TipoUsuario tipoUsuarioSaved = tipoUsuarioService.createTipoUsuario(tipoUsuario);
        tipoUsuarioSaved.setNombre("Profesor");
        tipoUsuarioSaved.setDescripcion("Profesor de la Universidad");
        tipoUsuarioSaved.setIdTipoUsuario(2L);
        tipoUsuarioService.updateTipoUsuario(tipoUsuarioSaved.getIdTipoUsuario(), tipoUsuarioSaved);
        TipoUsuario tipoUsuarioUpdated = tipoUsuarioService.getTipoUsuarioById(tipoUsuarioSaved.getIdTipoUsuario());
        assertNotEquals(null, tipoUsuarioUpdated);
    }

    @Test
    void hasDeletedTipoUsuario() {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNombre("Alumno");
        tipoUsuario.setDescripcion("Alumno de la Universidad");
        tipoUsuario.setIdTipoUsuario(1L);
        TipoUsuario tipoUsuarioSaved = tipoUsuarioService.createTipoUsuario(tipoUsuario);
        tipoUsuarioService.deleteTipoUsuario(tipoUsuarioSaved.getIdTipoUsuario());
    }

    @Test
    void hasGetTipoUsuarioById() {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNombre("Alumno");
        tipoUsuario.setDescripcion("Alumno de la Universidad");
        tipoUsuario.setIdTipoUsuario(1L);
        TipoUsuario tipoUsuarioSaved = tipoUsuarioService.createTipoUsuario(tipoUsuario);
        TipoUsuario tipoUsuarioUpdated = tipoUsuarioService.getTipoUsuarioById(tipoUsuarioSaved.getIdTipoUsuario());
        assertNotEquals(null, tipoUsuarioUpdated);
    }

    @Test
    void hasGetAllTipoUsuarios() {
        assertNotEquals(null, tipoUsuarioService.getAllTipoUsuarios());
    }
}
