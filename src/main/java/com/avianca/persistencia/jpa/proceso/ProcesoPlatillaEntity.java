package com.avianca.persistencia.jpa.proceso;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name = "PROCESO_PLANTILLA")
@Entity
public class ProcesoPlatillaEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Size(max = 8)
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Column(name = "CODIGO")
    private String codigo;
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
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
