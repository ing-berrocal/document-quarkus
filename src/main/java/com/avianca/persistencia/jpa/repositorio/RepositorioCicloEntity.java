package com.avianca.persistencia.jpa.repositorio;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Table(name = "REPOSITORIO_CICLO")
@Entity
public class RepositorioCicloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;    
    @Column(name = "FORMATO",nullable = false)
    private String formato;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "FECHA_VENCIMIENTO")
    private LocalDate fechaVencimiento;
    @Column(name = "REPOSITORIO_PLANTILLA_ID")
    private Long repositorioPlantillaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setRepositorioPlantillaId(Long repositorioPlantillaId) {
        this.repositorioPlantillaId = repositorioPlantillaId;
    }

    public Long getRepositorioPlantillaId() {
        return repositorioPlantillaId;
    }
    
    
}
