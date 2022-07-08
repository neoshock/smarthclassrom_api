package com.appdist.biometric.service.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.Usuario;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Long> {
    
    @Query(value = "select userAuthentication('?1')", nativeQuery = true)
    boolean userAuthentication(String fingerprint);

}
    