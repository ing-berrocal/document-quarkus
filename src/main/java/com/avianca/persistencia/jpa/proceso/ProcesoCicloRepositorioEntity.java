package com.avianca.persistencia.jpa.proceso;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "PROCESO_CICLO_REPOSITORIO")
@Entity
@NamedQueries({
    @NamedQuery(name = "ProcesoCicloRepositorioEntity.OBTENER_POR_PROCESOS", query = "UPDATE ProcesoCicloRepositorioEntity P SET repositorioId = :repositorioId WHERE P.procesoCicloId = :procesoCicloId AND P.repositorioTituloId = :repositorioTituloId")
})
public class ProcesoCicloRepositorioEntity {
 
    public static final String OBTENER_POR_PROCESOS = "#ProcesoCicloRepositorioEntity.OBTENER_POR_PROCESOS";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;    
    @Column(name = "PROCESO_CICLO_ID")
    private Long procesoCicloId;    
    @Column(name = "REPOSITORIO_TITULO_ID")
    private Long repositorioTituloId;
    @Column(name = "REPOSITORIO_ID")
    private Long repositorioId;
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

    public Long getRepositorioTituloId() {
        return repositorioTituloId;
    }

    public void setRepositorioTituloId(Long repositorioTituloId) {
        this.repositorioTituloId = repositorioTituloId;
    }

    public Long getRepositorioId() {
        return repositorioId;
    }

    public void setRepositorioId(Long repositorioId) {
        this.repositorioId = repositorioId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
