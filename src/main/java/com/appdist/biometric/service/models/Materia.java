package com.appdist.biometric.service.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_materia;

    private String nombre;
    private int creditos;

    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UsuariosMaterias> usuariosMaterias;

    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Horario> horarios;

    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MateriaAula> materiaAulas;

    public Materia() {
    }

    public long getId_materia() {
        return id_materia;
    }

    public void setId_materia(long id_materia) {
        this.id_materia = id_materia;
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

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public Set<MateriaAula> getMateriaAulas() {
        return materiaAulas;
    }

}
