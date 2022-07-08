package com.appdist.biometric.service.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        try{
            return materiasService.createMateria(materia);
        }catch(Exception e){
            return null;
        }
    }
}
