package com.appdist.biometric.service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.appdist.biometric.service.models.TipoUsuario;

public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Long> {
    
}
