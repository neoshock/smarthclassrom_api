package com.appdist.biometric.service.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "materias")
@Data
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String nombre;
    private int creditos;

    @ManyToMany
    private List<Usuario> usuarios;
    
    @OneToMany(mappedBy = "materia")
    private List<Horario> horarios;

    @ManyToMany
    @JoinTable(
        name = "aulas_materias", 
        joinColumns = @JoinColumn(name = "materias_id"), 
        inverseJoinColumns = @JoinColumn(name = "aula_id")
    )
    @JsonIgnore
    List<Aula> aulas;
}
