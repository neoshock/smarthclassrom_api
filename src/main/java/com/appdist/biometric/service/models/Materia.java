package com.appdist.biometric.service.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "materias")
public class Materia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idMateria;

    private String nombre;
    private int creditos;

    @JsonIgnore
    @OneToMany(mappedBy = "materias", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UsuariosMaterias> usuariosMaterias;

    public Materia() {
    }

    public Materia(long idMateria, String nombre, int creditos) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public long getIdMateria() {
        return idMateria;
    }
    
    public void setIdMateria(long idMateria) {
        this.idMateria = idMateria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<UsuariosMaterias> getUsuariosMaterias() {
        return usuariosMaterias;
    }

    public void setUsuariosMaterias(List<UsuariosMaterias> usuariosMaterias) {
        this.usuariosMaterias = usuariosMaterias;
    }

    
}
