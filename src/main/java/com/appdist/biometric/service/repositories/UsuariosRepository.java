package com.appdist.biometric.service.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.Usuario;
import com.appdist.biometric.service.models.request.AuthRequest;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Serializable> {
    
    @Query(value = "select * from userauthentication(?1)", nativeQuery = true)
    AuthRequest userAuthentication(Long uid);

    @Query(value = "SELECT * FROM public.usuarios where email = ?1", nativeQuery = true)
    Usuario getUsuarioByEmail(String email);

}
    