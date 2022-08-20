package com.appdist.biometric.service.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.Materia;

@Repository
public interface MateriasRepository extends CrudRepository<Materia, Long> {

    @Query(value = "select * from getmateriasbyemail(?1)", nativeQuery = true)
    ArrayList<Materia> getMateriasByEmail(String email);
}
    

