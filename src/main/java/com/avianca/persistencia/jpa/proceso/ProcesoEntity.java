package com.avianca.persistencia.jpa.proceso;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "PROCESO")
@Entity
public class ProcesoEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "EMPRESA_ID")
    private Long empresaID = 1L;
    @Column(name = "ASIGNA_TERCERO")
    private Boolean asignaTercero;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setEmpresaID(Long empresaID) {
        this.empresaID = empresaID;
    }

    public Long getEmpresaID() {
        return empresaID;
    }

    public void setAsignaTercero(Boolean asignaTercero) {
        this.asignaTercero = asignaTercero;
    }

    public Boolean getAsignaTercero() {
        return asignaTercero;
    }
    
    
}
