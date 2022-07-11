package com.appdist.biometric.service.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accesos_aulas")
public class AccesoAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_acceso_aula;

    private Date fecha_acceso;
    private boolean acceso_valido;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;

    public AccesoAula() {
    }

    public AccesoAula(long id_acceso_aula, Date fecha_acceso, boolean acceso_valido) {
        this.id_acceso_aula = id_acceso_aula;
        this.fecha_acceso = fecha_acceso;
        this.acceso_valido = acceso_valido;
    }

    public long getId_acceso_aula() {
        return id_acceso_aula;
    }

    public void setId_acceso_aula(long id_acceso_aula) {
        this.id_acceso_aula = id_acceso_aula;
    }

    public Date getFecha_acceso() {
        return fecha_acceso;
    }

    public void setFecha_acceso(Date fecha_acceso) {
        this.fecha_acceso = fecha_acceso;
    }

    public boolean isAcceso_valido() {
        return acceso_valido;
    }

    public void setAcceso_valido(boolean acceso_valido) {
        this.acceso_valido = acceso_valido;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

}
