package com.avianca.model;

import java.time.LocalDateTime;

public record RepositorioTitulo (
        Long id,
        String codigo,
        String titulo,
        String descripcion,
        Boolean tieneFechaVencimiento,
        LocalDateTime fechaCreacion,
        Proceso[] procesos) {

    @Override
    public String toString() {
        return this.codigo + " - " + this.titulo;
    }    
    
}
