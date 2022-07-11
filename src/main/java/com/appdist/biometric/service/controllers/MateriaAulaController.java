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

import com.appdist.biometric.service.models.MateriaAula;
import com.appdist.biometric.service.services.MateriaAulaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/materiaaula")
public class MateriaAulaController {
    @Autowired
    MateriaAulaService materiaAulaService;

    @GetMapping
    public ArrayList<MateriaAula> getAllMateriaAula() {
        return materiaAulaService.getAllMateriaAula();
    }

    @GetMapping("/{id}")
    public MateriaAula getMateriaAulaById(@PathVariable(value = "id") Long id) {
        return materiaAulaService.getMateriaAulaById(id);
    }

    @PostMapping
    public MateriaAula createMateriaAula(@RequestBody MateriaAula materiaAula) {
        try {
            return materiaAulaService.createMateriaAula(materiaAula);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public MateriaAula updateMateriaAula(@PathVariable(value = "id") Long id, @RequestBody MateriaAula materiaAula) {
        try {
            return materiaAulaService.updateMateriaAula(id, materiaAula);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMateriaAula(@PathVariable(value = "id") Long id) {
        materiaAulaService.deleteMateriaAula(id);
    }
}
