package com.appdist.biometric.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.MateriaAula;

@Repository
public interface MateriaAulaRepository extends CrudRepository<MateriaAula, Long> {

}
    
