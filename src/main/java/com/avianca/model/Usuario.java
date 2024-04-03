/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model;

import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
public class Usuario {
    
    private Long id;
    private String email;
    private String usuarioPassowrd;
    private String usuarioRol;
    private LocalDateTime fecahaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuarioPassowrd() {
        return usuarioPassowrd;
    }

    public void setUsuarioPassowrd(String usuarioPassowrd) {
        this.usuarioPassowrd = usuarioPassowrd;
    }

    public String getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(String usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public LocalDateTime getFecahaRegistro() {
        return fecahaRegistro;
    }

    public void setFecahaRegistro(LocalDateTime fecahaRegistro) {
        this.fecahaRegistro = fecahaRegistro;
    }
    
    
}
