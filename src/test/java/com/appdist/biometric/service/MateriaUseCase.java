package com.appdist.biometric.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appdist.biometric.service.models.Materia;
import com.appdist.biometric.service.services.MateriasService;

@SpringBootTest
public class MateriaUseCase {
    
    @Autowired
    private MateriasService materiasService;

    @Test
    void hasSavedMateria(){
        Materia materia = new Materia();
        materia.setCreditos(20);
        materia.setNombre("Matematicas");

        Materia materiaSaved = materiasService.createMateria(materia);

        assertNotEquals(null, materiaSaved);
    }
}
