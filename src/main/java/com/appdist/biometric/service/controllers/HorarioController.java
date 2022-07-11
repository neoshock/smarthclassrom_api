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

import com.appdist.biometric.service.models.Horario;
import com.appdist.biometric.service.services.HorarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    
    @Autowired
    HorarioService horarioService;

    @GetMapping
    public ArrayList<Horario> getAllHorario() {
        return horarioService.getAllHorario();
    }

    @GetMapping("/{id}")
    public Horario getHorarioById(@PathVariable(value = "id") Long id) {
        return horarioService.getHorarioById(id);
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioService.createHorario(horario);
    }

    @PutMapping("/{id}")
    public Horario updateHorario(@PathVariable(value = "id") Long id, @RequestBody Horario horario) {
        return horarioService.updateHorario(id, horario);
    }

    @DeleteMapping("/{id}")
    public void deleteHorario(@PathVariable(value = "id") Long id) {
        horarioService.deleteHorario(id);
    }
}
