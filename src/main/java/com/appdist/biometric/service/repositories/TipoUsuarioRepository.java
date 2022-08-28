package com.appdist.biometric.service.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Serializable> {
    
}
