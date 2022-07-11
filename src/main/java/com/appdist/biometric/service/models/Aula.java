package com.appdist.biometric.service.models;

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
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_aula;

    private String nombre;
    private String facultad;
    private int capacidad;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AccesoAula> accesos;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MateriaAula> materiaAula;

    public Aula() {
    }

    public Aula(long id_aula, String nombre, String facultad, int capacidad) {
        this.id_aula = id_aula;
        this.nombre = nombre;
        this.facultad = facultad;
        this.capacidad = capacidad;
    }

    public long getId_aula() {
        return id_aula;
    }

    public void setId_aula(long id_aula) {
        this.id_aula = id_aula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Set<AccesoAula> getAccesos() {
        return accesos;
    }

    public Set<MateriaAula> getMateriaAula() {
        return materiaAula;
    }

}
