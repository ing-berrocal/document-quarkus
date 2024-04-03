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
    @Column(name = "PROCESO_ID")
    private Long procesoId;
    
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;    
    @Column(name = "EMPRESA_ID")
    private Long empresaId;    
    @Column(name = "TITULO",nullable = false)
    private String titulo;        
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

    public Long getProcesoId() {
        return procesoId;
    }

    public void setProcesoId(Long procesoId) {
        this.procesoId = procesoId;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
