package com.appdist.biometric.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appdist.biometric.service.models.Horario;
import com.appdist.biometric.service.models.Materia;
import com.appdist.biometric.service.services.HorarioService;

@SpringBootTest
public class HorarioUseCase {
    
    @Autowired
    private HorarioService horarioService;

    @Test
    void hasSavedHorario(){
        Horario horario = new Horario();
        Materia materia = new Materia();
        Date diaHorario = new Date();
        LocalDateTime horaInicio = LocalDateTime.now();
        LocalDateTime horaFin = LocalDateTime.now();

        materia.setId_materia(1L);
        horario.setDia_horario(diaHorario);
        horario.setHora_inicio(horaInicio);
        horario.setHora_fin(horaFin);
        horario.setMateria(materia);

        Horario horarioSaved = horarioService.createHorario(horario);

        assertNotEquals(null, horarioSaved);
    }

    @Test
    void hasUpdatedHorario(){
        Horario horario = new Horario();
        Materia materia = new Materia();
        Date diaHorario = new Date();
        LocalDateTime horaInicio = LocalDateTime.now();
        LocalDateTime horaFin = LocalDateTime.now();

        materia.setId_materia(1L);
        horario.setDia_horario(diaHorario);
        horario.setHora_inicio(horaInicio);
        horario.setHora_fin(horaFin);
        horario.setMateria(materia);

        Horario horarioSaved = horarioService.createHorario(horario);
        horarioSaved.setDia_horario(diaHorario);
        horarioSaved.setHora_inicio(horaInicio);
        horarioSaved.setHora_fin(horaFin);
        horarioSaved.setMateria(materia);
        horarioService.updateHorario(horarioSaved.getId_horario(), horarioSaved);
        Horario horarioUpdated = horarioService.getHorarioById(horarioSaved.getId_horario());
        assertNotEquals(null, horarioUpdated);
    }

    @Test
    void hasDeletedHorario(){
        Horario horario = new Horario();
        Materia materia = new Materia();
        Date diaHorario = new Date();
        LocalDateTime horaInicio = LocalDateTime.now();
        LocalDateTime horaFin = LocalDateTime.now();

        materia.setId_materia(1L);
        horario.setDia_horario(diaHorario);
        horario.setHora_inicio(horaInicio);
        horario.setHora_fin(horaFin);
        horario.setMateria(materia);

        Horario horarioSaved = horarioService.createHorario(horario);
        horarioService.deleteHorario(horarioSaved.getId_horario());
    }

    @Test
    void hasGetHorarioById(){
        Horario horario = new Horario();
        Materia materia = new Materia();
        Date diaHorario = new Date();
        LocalDateTime horaInicio = LocalDateTime.now();
        LocalDateTime horaFin = LocalDateTime.now();

        materia.setId_materia(1L);
        horario.setDia_horario(diaHorario);
        horario.setHora_inicio(horaInicio);
        horario.setHora_fin(horaFin);
        horario.setMateria(materia);

        Horario horarioSaved = horarioService.createHorario(horario);
        Horario horarioById = horarioService.getHorarioById(horarioSaved.getId_horario());
        assertNotEquals(null, horarioById);
    }

    @Test
    void hasGetAllHorarios(){
        Iterable<Horario> horarios = horarioService.getAllHorario();
        assertNotEquals(null, horarios);
    }
}
