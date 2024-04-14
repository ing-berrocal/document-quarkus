/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.repositorio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
@Table(name = "REPOSITORIO_PLANTILLA")
@Entity
public class RepositorioPlantillaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;
    @Column(name = "CODIGO",nullable = false)
    private String codigo;
    @Column(name = "TITULO",nullable = false)
    private String titulo;    
    @Column(name = "DESCRIPCION",nullable = false)
    private String descripcion;
    @Column(name = "FECHA_REGISTRO",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "EMPRESA_ID",nullable = false)
    private Long empresaId;
    @Column(name = "TIENE_FECHA_VENCIMIENTO",nullable = false)
    private Boolean tieneFechaVencimiento;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Boolean getTieneFechaVencimiento() {
        return tieneFechaVencimiento;
    }

    public void setTieneFechaVencimiento(Boolean tieneFechaVencimiento) {
        this.tieneFechaVencimiento = tieneFechaVencimiento;
    }
    
    
     
}
