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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    public UsuariosMaterias() {
    }

    public long getId_usuario_materia() {
        return id_usuario_materia;
    }

    public void setId_usuario_materia(long id_usuario_materia) {
        this.id_usuario_materia = id_usuario_materia;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
