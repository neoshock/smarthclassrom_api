package com.appdist.biometric.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdist.biometric.service.models.Dispositivo;
import com.appdist.biometric.service.repositories.DispositivoRepository;

@Service
public class DispositivoService {

    @Autowired
    DispositivoRepository dispositivoRepository;

    public ArrayList<Dispositivo> getAlDispositivos() {
        return (ArrayList<Dispositivo>) dispositivoRepository.findAll();
    }

    public ArrayList<Dispositivo> getDispositivosByUsuario(Long usuario_id){
        return dispositivoRepository.getDispositivoByUsuario(usuario_id);
    }

    public Object updateEstadoDispositivo(Integer dispositivo_id, boolean estado){
        return dispositivoRepository.updateEstadoDispositivo(dispositivo_id, estado);
    }
    
}
