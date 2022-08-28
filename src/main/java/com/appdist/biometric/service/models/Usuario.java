package com.appdist.biometric.service.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 127)
    private long id;

    boolean isUserRegisterFingerprint;
    String nombre;
    String apellido;
    String password;
    String telefono;
    String email;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    @JsonManagedReference
    TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<AccesoAula> accesosAula;
    
}
