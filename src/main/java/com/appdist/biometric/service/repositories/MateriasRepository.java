package com.appdist.biometric.service.repositories;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appdist.biometric.service.models.Materia;

@Repository
public interface MateriasRepository extends CrudRepository<Materia, Serializable> {

    @Query(value = "select * from getmateriasbyemail(?1)", nativeQuery = true)
    ArrayList<Materia> getMateriasByEmail(String email);

    @Query(value = "select fecha_asistencia from asistencias where materia_id = ?1 group by fecha_asistencia;", nativeQuery = true)
    ArrayList<Object> getFechaAsistenciasByMateria(Integer materia_id);

    @Query(value = "select a.id as asistencia_id, concat(u.nombre, ' ', u.apellido) as nombres,a.valido from asistencias a inner join usuarios u on a.usuario_id = u.id inner join tipo_usuario tp on u.id_tipo_usuario = tp.id where materia_id = ?1 and to_char(fecha_asistencia, 'yyyy-mm-dd') = ?2 and tp.nombre = 'alumno';", nativeQuery = true)
    ArrayList<Object> getAsistenciasEstudiantes(Integer materia_id, String fecha);

    @Query(value =  "select * from updateAsistencia(?2,?1);", nativeQuery = true)
    Object updateAsistenciaValida(boolean valido, Integer asistencia_id);
}
    

