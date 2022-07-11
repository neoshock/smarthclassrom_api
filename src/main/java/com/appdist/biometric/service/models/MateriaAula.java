package com.appdist.biometric.service.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materias_aulas")
public class MateriaAula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_materia_aula;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;

    public long getId_materia_aula() {
        return id_materia_aula;
    }

    public void setId_materia_aula(long id_materia_aula) {
        this.id_materia_aula = id_materia_aula;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    
}
