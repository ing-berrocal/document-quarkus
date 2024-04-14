package com.avianca.model;

import java.time.LocalDateTime;

public record RepositorioPlantilla (
        Long id,
        String codigo,
        String titulo,
        String descripcion,
        Boolean tieneFechaVencimiento,
        LocalDateTime fechaCreacion,
        ProcesoPlantilla[] procesos) {

    @Override
    public String toString() {
        return this.codigo + " - " + this.titulo;
    }    
    
}
