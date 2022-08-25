package com.appdist.biometric.service.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "usuarios")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id_usuario"
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 127)
    private long id_usuario;

    private boolean isUserRegisterFingerprint;

    private String nombre;
    private String apellido;
    private String fingerprint;

    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private Set<AccesoAula> accesosAula;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private Set<UsuariosMaterias> usuariosMaterias;

    public Usuario() {

    }

    public Usuario(long id_usuario, String nombre, String apellido, String fingerprint, String telefono, String email) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fingerprint = fingerprint;
        this.telefono = telefono;
        this.email = email;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isUserRegisterFingerprint() {
        return isUserRegisterFingerprint;
    }

    public void setUserRegisterFingerprint(boolean isUserRegisterFingerprint) {
        this.isUserRegisterFingerprint = isUserRegisterFingerprint;
    }

}
