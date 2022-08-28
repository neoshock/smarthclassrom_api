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
import com.appdist.biometric.service.models.request.MateriaRequest;
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
    public ResponseEntity<?> createMateria(@RequestBody MateriaRequest materia) {
        try {
            Materia materiaResult = new Materia();
            materiaResult.setNombre(materia.getNombre());
            materiaResult.setCreditos(materia.getCreditos());
            materiaResult = materiasService.createMateria(materiaResult);
            if (materiaResult != null) {
                return ResponseEntity.ok(materiaResult);
            } else {
                return ResponseEntity.badRequest().body("Error al registrar la materia");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMateria(@PathVariable(value = "id") Long id, @RequestBody MateriaRequest materia) {
        try {
            Materia materiaResult = new Materia();
            materiaResult.setNombre(materia.getNombre());
            materiaResult.setCreditos(materia.getCreditos());
            materiaResult = materiasService.updateMateria(id, materiaResult);
            if (materiaResult != null) {
                return ResponseEntity.ok(materiaResult);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
            if (materias != null && materias.size() > 0) {
                for (Materia m : materias) {
                    m.setUsuarios(null);
                }
                return ResponseEntity.ok(materias);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
