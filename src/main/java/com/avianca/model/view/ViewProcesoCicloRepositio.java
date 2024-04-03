/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model.view;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public record ViewProcesoCicloRepositio(Long id,Long repositorioTituloId,
        String codigo,String titulo,Boolean esObligatio, Long repositorioId,ViewProcesoCicloRepositioData data) {

    public static ViewProcesoCicloRepositio getInstance(Long id, Long repositorioTituloId,
        String codigo,String titulo,Boolean esObligatio, Long repositorioId, String formato, LocalDate fechahVencimiento) {
        return new ViewProcesoCicloRepositio(id, repositorioTituloId, codigo, titulo, esObligatio, repositorioId, 
        repositorioId != 0 ? new ViewProcesoCicloRepositioData(repositorioId, formato, fechahVencimiento) : null );
    }
    
}
