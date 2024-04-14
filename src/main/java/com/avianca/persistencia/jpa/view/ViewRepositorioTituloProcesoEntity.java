/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.view;

import com.avianca.persistencia.jpa.util.ProcesoRepositorioPlantillaPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
@Table(name = "view_proceso_plantilla_repositorio_plantilla")
@Entity
@NamedQueries({
    @NamedQuery(name = ViewRepositorioTituloProcesoEntity.BYPROCESOID,query = "SELECT v FROM ViewRepositorioTituloProcesoEntity v WHERE v.empresaId = :empresaId AND v.repositorioTituloProcesoPK.procesoId = :procesoId")
})
public class ViewRepositorioTituloProcesoEntity{

    public static final String BYPROCESOID = "ViewRepositorioTituloProcesoEntity.PROCESOID";
    
    @EmbeddedId
    private ProcesoRepositorioPlantillaPK repositorioTituloProcesoPK;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "ES_OBLIGATORIO",nullable = false)
    private Boolean esObligatorio;
    @Column(name = "EMPRESA_ID")
    private Long empresaId;
    @Column(name = "CODIGO",nullable = false)
    private String codigo;
    @Column(name = "TITULO",nullable = false)
    private String titulo;
    
    public ProcesoRepositorioPlantillaPK getRepositorioTituloProcesoPK() {
        return repositorioTituloProcesoPK;
    }

    public void setRepositorioTituloProcesoPK(ProcesoRepositorioPlantillaPK repositorioTituloProcesoPK) {
        this.repositorioTituloProcesoPK = repositorioTituloProcesoPK;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(Boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    } 

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
