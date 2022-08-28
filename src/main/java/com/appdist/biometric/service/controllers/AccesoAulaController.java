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

import com.appdist.biometric.service.models.AccesoAula;
import com.appdist.biometric.service.services.AccesoAulaService;

@RestController
@RequestMapping("/api/accesoaula")
public class AccesoAulaController {
    @Autowired
    AccesoAulaService accesoAulaService;

    @GetMapping
    public ArrayList<AccesoAula> getAllAccesoAula() {
        return accesoAulaService.getAllAccesoAula();
    }

    @GetMapping("/{id}")
    public AccesoAula getAccesoAulaById(@PathVariable(value = "id") Long id) {
        return accesoAulaService.getAccesoAulaById(id);
    }

    @PostMapping
    public AccesoAula createAccesoAula(@RequestBody AccesoAula accesoAula) {
        try {
            return accesoAulaService.createAccesoAula(accesoAula);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public AccesoAula updateAccesoAula(@PathVariable(value = "id") Long id, AccesoAula accesoAula) {
        try {
            return accesoAulaService.updateAccesoAula(id, accesoAula);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccesoAula(@PathVariable(value = "id") Long id) {
        accesoAulaService.deleteAccesoAula(id);
    }
}
