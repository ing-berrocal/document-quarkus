/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.view.procesociclo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
@Table(name = "VIEW_PROCESO_CICLO")
@Entity
@NamedQueries({
    @NamedQuery(name = ViewProcesoCicloEntity.BYPROCESOID,query = "SELECT v FROM ViewRepositorioTituloProcesoEntity v WHERE v.empresaId = :empresaId")
})
public class ViewProcesoCicloEntity{

    public static final String BYPROCESOID = "ViewProcesoCicloEntity.PROCESOID";
    
    @Id
    private Long Id;
    @Column(name = "PLANTILLA_ID")
    private Long plantillaId;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;    
    @Column(name = "EMPRESA_ID")
    private Long empresaId;    
    @Column(name = "PLANTILLA_TITULO",nullable = false)
    private String pantillaTitulo;
    @Column(name = "CICLO_TITULO",nullable = false)
    private String cicloTitulo;
    @Column(name = "FECHA_VALIDO_HASTA",nullable = false)
    private LocalDate fechaValidoHasta;        
    @Transient
    private Boolean esObligatorio;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getPlantillaId() {
        return plantillaId;
    }

    public void setPlantillaId(Long plantillaId) {
        this.plantillaId = plantillaId;
    }

    public String getCicloTitulo() {
        return cicloTitulo;
    }

    public void setCicloTitulo(String cicloTitulo) {
        this.cicloTitulo = cicloTitulo;
    }

    public String getPantillaTitulo() {
        return pantillaTitulo;
    }

    public void setPantillaTitulo(String pantillaTitulo) {
        this.pantillaTitulo = pantillaTitulo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public LocalDate getFechaValidoHasta() {
        return fechaValidoHasta;
    }

    public void setFechaValidoHasta(LocalDate fechaValidoHasta) {
        this.fechaValidoHasta = fechaValidoHasta;
    }

    public Boolean getEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(Boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    }
    
}
