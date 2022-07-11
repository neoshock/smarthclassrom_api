package com.appdist.biometric.service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdist.biometric.service.models.Aula;
import com.appdist.biometric.service.services.AulaService;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {
    @Autowired
    AulaService aulaService;

    @GetMapping()
    public ArrayList<Aula> getAllAulas() {
        return aulaService.getAllAulas();
    }

    @GetMapping("/{id}")
    public Aula getAulaById(@PathVariable(value = "id") Long id) {
        return aulaService.getAulaById(id);
    }

    @PostMapping()
    public Aula createAula(Aula aula) {
        try {
            return aulaService.createAula(aula);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Aula updateAula(@PathVariable(value = "id") Long id, Aula aula) {
        try {
            return aulaService.updateAula(id, aula);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAula(@PathVariable(value = "id") Long id) {
        aulaService.deleteAula(id);
    }
}
