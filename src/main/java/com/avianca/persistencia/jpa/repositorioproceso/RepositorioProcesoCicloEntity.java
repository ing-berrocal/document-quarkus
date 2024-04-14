/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.repositorioproceso;

import com.avianca.persistencia.jpa.util.ProcesoRepositorioPlantillaPK;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
@Table(name = "PROCESO_REPOSITORIO_CICLO")
@Entity
public class RepositorioProcesoCicloEntity {

    @EmbeddedId
    @AttributeOverrides({
      @AttributeOverride(name = "repositorioTituloId", column = @Column(name = "REPOSITORIO_ID")),
      @AttributeOverride(name = "procesoId", column = @Column(name = "PROCESO_CICLO_ID"))
    })
    private ProcesoRepositorioPlantillaPK repositorioTituloProcesoPK;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    
    /*@ManyToOne
    @MapsId("repositorioTituloId")
    @JoinColumn(name = "proceso_ciclo_id",insertable = false)
    private ProcesoCicloEntity procesoCiclo;*/

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
    
    public static RepositorioProcesoCicloEntity getInstance(Long repositorioId,Long procesoCicloId){
        RepositorioProcesoCicloEntity entity = new RepositorioProcesoCicloEntity();
        entity.setRepositorioTituloProcesoPK(new ProcesoRepositorioPlantillaPK(repositorioId, procesoCicloId));
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }
}
