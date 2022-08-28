package com.appdist.biometric.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appdist.biometric.service.models.Aula;
import com.appdist.biometric.service.services.AulaService;

@SpringBootTest
public class AulaUseCase {

    @Autowired
    AulaService aulasService;

    @Test
    void hasSavedAula() {
        Aula aula = new Aula();
        aula.setNombre("Aula 1");
        aula.setCapacidad(20);
        aula.setFacultad("Facultad de Ingenieria");
        Aula aulaSaved = aulasService.createAula(aula);
        assertNotEquals(null, aulaSaved);
    }

    @Test
    void hasUpdatedAula() {
        Aula aula = new Aula();
        aula.setNombre("Aula 1");
        aula.setCapacidad(20);
        aula.setFacultad("Facultad de Ingenieria");
        Aula aulaSaved = aulasService.createAula(aula);
        aulaSaved.setNombre("Aula 2");
        aulaSaved.setCapacidad(30);
        aulaSaved.setFacultad("Facultad de Ingenieria");
        aulasService.updateAula(aulaSaved.getId(), aulaSaved);
        Aula aulaUpdated = aulasService.getAulaById(aulaSaved.getId());
        assertNotEquals(null, aulaUpdated);
    }

    @Test
    void hasDeletedAula() {
        Aula aula = new Aula();
        aula.setNombre("Aula 1");
        aula.setCapacidad(20);
        aula.setFacultad("Facultad de Ingenieria");
        Aula aulaSaved = aulasService.createAula(aula);
        aulasService.deleteAula(aulaSaved.getId());
    }

    @Test
    void hasGetAulaById() {
        Aula aula = new Aula();
        aula.setNombre("Aula 1");
        aula.setCapacidad(20);
        aula.setFacultad("Facultad de Ingenieria");
        Aula aulaSaved = aulasService.createAula(aula);
        Aula aulaById = aulasService.getAulaById(aulaSaved.getId());
        assertNotEquals(null, aulaById);
    }

    @Test
    void hasGetAllAulas() {
        assertNotEquals(null, aulasService.getAllAulas());
    }
}
