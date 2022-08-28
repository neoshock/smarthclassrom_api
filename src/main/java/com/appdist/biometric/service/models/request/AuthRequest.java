package com.appdist.biometric.service.models.request;

import lombok.Data;

@Data
public class AuthRequest {

    String nombre;
    boolean acceso_valido;

    public AuthRequest(String nombre, boolean acceso_valido) {
        this.nombre = nombre;
        this.acceso_valido = acceso_valido;
    }
    
    public AuthRequest() {

    }
}
