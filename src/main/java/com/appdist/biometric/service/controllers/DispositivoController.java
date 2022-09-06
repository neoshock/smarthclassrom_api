package com.appdist.biometric.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdist.biometric.service.services.DispositivoService;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {
    
    @Autowired
    DispositivoService dispositivoService;

    @GetMapping()
    public ResponseEntity<?> getAllDispositivos(){
        try{
            return ResponseEntity.ok(dispositivoService.getAlDispositivos());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getDipositivoByUsuario(@PathVariable(value = "id") Long usuario_id){
        try{
            return ResponseEntity.ok(dispositivoService.getDispositivosByUsuario(usuario_id));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/{estado}")
    public ResponseEntity<?> updateEstadoDispositivo(@PathVariable(value = "id") Integer dispositivo_id, @PathVariable(value = "estado") boolean estado){
        try{
            return ResponseEntity.ok(dispositivoService.updateEstadoDispositivo(dispositivo_id, estado));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
