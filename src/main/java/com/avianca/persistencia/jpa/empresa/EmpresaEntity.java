package com.avianca.persistencia.jpa.empresa;

import java.time.LocalDateTime;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "EMPRESA")
@Entity
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "NIT")
    private String nit;
    @NotNull
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @NotNull
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fecahaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDateTime getFecahaRegistro() {
        return fecahaRegistro;
    }

    public void setFecahaRegistro(LocalDateTime fecahaRegistro) {
        this.fecahaRegistro = fecahaRegistro;
    }

}
