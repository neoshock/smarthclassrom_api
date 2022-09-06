package com.appdist.biometric.service.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.Dispositivo;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    
    @Query(value = "SELECT * FROM public.dispositivos where usuario_id = ?1", nativeQuery = true)
    ArrayList<Dispositivo> getDispositivoByUsuario(Long usuario_id);

    @Query(value = "SELECT * from public.updatedispositivo(?1,?2)", nativeQuery = true)
    Object updateEstadoDispositivo(Integer id_dispositivo, boolean estado);

}
