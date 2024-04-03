package com.avianca.persistencia.jpa.tercero;

import com.avianca.model.TipoDocumento;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Table(name = "TERCERO")
@Entity
@NamedQueries({
    @NamedQuery(name = TerceroEntity.COUNT_TERCERO, query = "select count(*) from TerceroEntity p where p.tipoDocumento = :tipoDocumento AND p.documento = :documento")
})
public class TerceroEntity {

    public static final String COUNT_TERCERO = "TerceroEntity.countByTercero";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;
    @NotNull
    @Column(name = "NUMERO_DOCUMENTO")
    private String documento;
    @NotNull
    @Column(name = "APELLIDOS")
    private String apellidos;
    @NotNull
    @Column(name = "NOMBRES")
    private String nombres;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
}
