package com.appdist.biometric.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.Usuarios;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {
    
}
    