package com.appdist.biometric.service.models;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioResponse {

    private long id;
    private boolean isUserRegisterFingerprint;
    private String nombre;
    private String apellido;
    private String fingerprint;
    private String telefono;
    private String email;

    public List<Materia> materias;
}
