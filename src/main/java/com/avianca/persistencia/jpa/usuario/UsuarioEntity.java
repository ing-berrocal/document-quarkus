package com.avianca.persistencia.jpa.usuario;

import java.time.LocalDateTime;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "USUARIO")
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "USUARIO_PASSWORD")
    private String usuarioPassowrd;
    @NotNull
    @Column(name = "USUARIO_ROL")
    private String usuarioRol;
    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fecahaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecahaRegistro() {
        return fecahaRegistro;
    }

    public void setFecahaRegistro(LocalDateTime fecahaRegistro) {
        this.fecahaRegistro = fecahaRegistro;
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

    
}
