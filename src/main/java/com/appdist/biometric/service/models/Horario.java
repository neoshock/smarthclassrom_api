package com.appdist.biometric.service.models;

import java.time.LocalDateTime;
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
@Table(name = "horarios")
public class Horario {
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_horario;

    private Date dia_horario;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    public Horario() {
    }

    public Horario(Long id_horario, Date dia_horario, LocalDateTime hora_inicio, LocalDateTime hora_fin) {
        this.id_horario = id_horario;
        this.dia_horario = dia_horario;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Long getId_horario() {
        return id_horario;
    }

    public void setId_horario(Long id_horario) {
        this.id_horario = id_horario;
    }

    public Date getDia_horario() {
        return dia_horario;
    }

    public void setDia_horario(Date dia_horario) {
        this.dia_horario = dia_horario;
    }

    public LocalDateTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalDateTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalDateTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalDateTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
