/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.procesorepositorio;

import com.avianca.persistencia.jpa.util.ProcesoRepositorioPlantillaPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
@Table(name = "PROCESO_PLANTILLA_REPOSITORIO_PLANTILLA")
@Entity
public class ProcesoRepositorioPlantillaEntity {

    @EmbeddedId
    private ProcesoRepositorioPlantillaPK repositorioTituloProcesoPK;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "ES_OBLIGATORIO",nullable = false)
    private Boolean esObligatorio;

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
    
    public static ProcesoRepositorioPlantillaEntity getInstance(Long repositorioTituloId,Long procesoId){
        ProcesoRepositorioPlantillaEntity entity = new ProcesoRepositorioPlantillaEntity();
        entity.setRepositorioTituloProcesoPK(new ProcesoRepositorioPlantillaPK(repositorioTituloId, procesoId));
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setEsObligatorio(Boolean.TRUE);
        return entity;
    }
}
