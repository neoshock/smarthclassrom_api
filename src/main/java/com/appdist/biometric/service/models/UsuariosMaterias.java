package com.appdist.biometric.service.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios_materias")
public class UsuariosMaterias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_usuario_materia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuarios;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_materia", nullable = false)
    private Materias materias;

    public UsuariosMaterias() {
    }

    public UsuariosMaterias(final long id_usuario_materia, final Usuarios usuarios, final Materias materias) {
        this.id_usuario_materia = id_usuario_materia;
        this.usuarios = usuarios;
        this.materias = materias;
    }

    public long getId_usuario_materia() {
        return id_usuario_materia;
    }

    public void setId_usuario_materia(final long id_usuario_materia) {
        this.id_usuario_materia = id_usuario_materia;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(final Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(final Materias materias) {
        this.materias = materias;
    }

    
}
