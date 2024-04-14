package com.avianca.persistencia.jpa.proceso;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "proceso_ciclo_repositorio_ciclo")
@Entity
@NamedQueries({
    @NamedQuery(name = "ProcesoCicloRepositorioCicloEntity.OBTENER_POR_PROCESOS", query = "UPDATE ProcesoCicloRepositorioCicloEntity P SET repositorioCicloId = :repositorioId WHERE P.procesoCicloId = :procesoCicloId AND P.repositorioPlantillaId = :repositorioTituloId")
})
public class ProcesoCicloRepositorioCicloEntity {
 
    public static final String OBTENER_POR_PROCESOS = "#ProcesoCicloRepositorioCicloEntity.OBTENER_POR_PROCESOS";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;    
    @Column(name = "PROCESO_CICLO_ID")
    private Long procesoCicloId;    
    @Column(name = "REPOSITORIO_PLANTILLA_ID")
    private Long repositorioPlantillaId;
    @Column(name = "REPOSITORIO_CICLO_ID")
    private Long repositorioCicloId;
    @NotNull
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProcesoCicloId() {
        return procesoCicloId;
    }

    public void setProcesoCicloId(Long procesoCicloId) {
        this.procesoCicloId = procesoCicloId;
    }

    public Long getRepositorioPlantillaId() {
        return repositorioPlantillaId;
    }

    public void setRepositorioPlantillaId(Long repositorioPlantillaId) {
        this.repositorioPlantillaId = repositorioPlantillaId;
    }

    public Long getRepositorioCicloId() {
        return repositorioCicloId;
    }

    public void setRepositorioCicloId(Long repositorioCicloId) {
        this.repositorioCicloId = repositorioCicloId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
