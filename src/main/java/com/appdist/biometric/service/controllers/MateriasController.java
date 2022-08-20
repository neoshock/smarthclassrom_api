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

import com.appdist.biometric.service.models.Materia;
import com.appdist.biometric.service.services.MateriasService;

@RestController
@RequestMapping("api/materias")
public class MateriasController {
    @Autowired
    MateriasService materiasService;

    @GetMapping()
    public ArrayList<Materia> getAllMaterias() {
        return materiasService.getAllMaterias();
    }

    @GetMapping("/{id}")
    public Materia getMateriaById(@PathVariable(value = "id") Long id) {
        return materiasService.getMateriaById(id);
    }

    @PostMapping()
    public Materia createMateria(@RequestBody Materia materia) {
        try {
            return materiasService.createMateria(materia);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Materia updateMateria(@PathVariable(value = "id") Long id, @RequestBody Materia materia) {
        try {
            return materiasService.updateMateria(id, materia);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMateria(@PathVariable(value = "id") Long id) {
        materiasService.deleteMateria(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getMateriaByEmail(@PathVariable(value = "email") String email) {
        try {
            ArrayList<Materia> materias = materiasService.getMateriasByEmail(email);
            if (materias != null || materias.size() > 0) {
                return ResponseEntity.ok(materias);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Materia no encontrada");
        }
    }
}
