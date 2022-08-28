package com.appdist.biometric.service.models.request;

import lombok.Data;

@Data
public class AuthRequest {
    String nombre;
    boolean acceso_valido;
}
