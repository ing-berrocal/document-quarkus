/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource.request;

/**
 *
 * @author Lenovo
 */
public record RepositorioPlantillaRequest (
        String codigo,
        String titulo,
        String descripcion,
        Boolean tieneFechaVencimiento,
        Long[] procesos) {

    @Override
    public String toString() {
        return this.codigo + " - " + this.titulo;
    }    
    
}
