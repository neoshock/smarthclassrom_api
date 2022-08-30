package com.appdist.biometric.service.models.request;

import java.math.BigInteger;

import lombok.Data;

@Data
public class AsistenciaEstudianteResponse {
    BigInteger asistenciaId;
    String nombres;
    boolean valido;
}
