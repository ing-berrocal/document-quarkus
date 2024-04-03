/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.repositorioproceso;

import com.avianca.persistencia.jpa.util.RepositorioTituloProcesoPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
@Table(name = "REPOSITORIO_TITULO_PROCESO")
@Entity
public class RepositorioTituloProcesoEntity {

    @EmbeddedId
    private RepositorioTituloProcesoPK repositorioTituloProcesoPK;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "ES_OBLIGATORIO",nullable = false)
    private Boolean esObligatorio;

    public RepositorioTituloProcesoPK getRepositorioTituloProcesoPK() {
        return repositorioTituloProcesoPK;
    }

    public void setRepositorioTituloProcesoPK(RepositorioTituloProcesoPK repositorioTituloProcesoPK) {
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
    
    public static RepositorioTituloProcesoEntity getInstance(Long repositorioTituloId,Long procesoId){
        RepositorioTituloProcesoEntity entity = new RepositorioTituloProcesoEntity();
        entity.setRepositorioTituloProcesoPK(new RepositorioTituloProcesoPK(repositorioTituloId, procesoId));
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setEsObligatorio(Boolean.TRUE);
        return entity;
    }
}
