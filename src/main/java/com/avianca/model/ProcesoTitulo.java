/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model;

import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
public record ProcesoTitulo(
        Long tituloId,
        String codigo,
        String descripcion,
        LocalDateTime fechaCreacion,
        Boolean esObligatorio
        ) {
    
}
