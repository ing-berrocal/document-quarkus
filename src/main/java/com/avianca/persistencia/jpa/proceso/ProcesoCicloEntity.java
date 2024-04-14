package com.avianca.persistencia.jpa.proceso;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "PROCESO_CICLO")
@Entity
public class ProcesoCicloEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "proceso_plantilla_id")
    private ProcesoPlatillaEntity procesoEntity;
    @NotNull
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "FECHA_VALIDO_HASTA")
    private LocalDate fechaValidoHasta;
    @Column(name = "ESTA_TERMINADO")
    private Boolean terminado;
    @NotNull
    @Column(name = "TITULO")
    private String titulo;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public ProcesoPlatillaEntity getProcesoEntity() {
        return procesoEntity;
    }

    public void setProcesoEntity(ProcesoPlatillaEntity procesoEntity) {
        this.procesoEntity = procesoEntity;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaValidoHasta() {
        return fechaValidoHasta;
    }

    public void setFechaValidoHasta(LocalDate fechaValidoHasta) {
        this.fechaValidoHasta = fechaValidoHasta;
    }

    public Boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }        
}
