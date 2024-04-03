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
public record ViewProcesoCiclo(Long id,Long procesoId,String titulo, LocalDateTime fechaRegistro, LocalDate fechaValidoHasta){
    
}
