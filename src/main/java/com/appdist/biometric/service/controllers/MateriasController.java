package com.appdist.biometric.service.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

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
import com.appdist.biometric.service.models.request.AsistenciaEstudianteResponse;
import com.appdist.biometric.service.models.request.AsistenciaResponse;
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
                    m.setHorarios(null);
                }
                return ResponseEntity.ok(materias);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/fecha-asistencia")
    public ResponseEntity<?> getFechasAsistenciasByMateria(@PathVariable(value = "id") Integer materia_id){
        try {
            ArrayList<Object> fechasAsistencias = materiasService.getAsistenciaByMateria(materia_id);
            if(fechasAsistencias != null){
                ArrayList<AsistenciaResponse> asistenciaResponses = new ArrayList<>();
                for (Object request: fechasAsistencias){
                    AsistenciaResponse asistencia = new AsistenciaResponse();
                    asistencia.setFechaAsistencia((Date) request);
                    asistenciaResponses.add(asistencia);
                }
                return ResponseEntity.ok(asistenciaResponses);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/asistencias/{fecha}")
    public ResponseEntity<?> getAsistenciaMaterias(@PathVariable(value = "id") Integer materia_id, @PathVariable(value = "fecha") String fecha){
        try{
            ArrayList<Object> asistencias = materiasService.getAlumnosAsistencia(materia_id, fecha);
            if (asistencias != null){
                Object[] index;
                ArrayList<AsistenciaEstudianteResponse> asistenciaEstudianteResponses = new ArrayList<>();
                for(Object asistencia: asistencias){
                    AsistenciaEstudianteResponse estudianteResponse = new AsistenciaEstudianteResponse();
                    index = (Object[]) asistencia;
                    estudianteResponse.setAsistenciaId((BigInteger) index[0]);
                    estudianteResponse.setNombres((String) index[1]);
                    estudianteResponse.setValido((boolean) index[2]);
                    asistenciaEstudianteResponses.add(estudianteResponse);
                }
                return ResponseEntity.ok(asistenciaEstudianteResponses);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/validar/{id}/{estado}")
    public ResponseEntity<?> setAsistencia(@PathVariable(value = "id") Integer asistencia_id,@PathVariable(value = "estado") boolean valido){
        try {
            Object result = materiasService.setAsistenciaValida(valido, asistencia_id);
            if (result != null){
                return ResponseEntity.ok().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
