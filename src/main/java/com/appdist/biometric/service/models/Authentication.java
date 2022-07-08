package com.appdist.biometric.service.models;

public class Authentication {
    private String finger;

    public Authentication(String finger) {
        this.finger = finger;
    }
    
    public Authentication() {
    }

    public String getFinger() {
        return finger;
    }

    public void setFinger(String finger) {
        this.finger = finger;
    }
}
