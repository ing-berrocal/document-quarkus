/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
public record ProcesoCiclo(Long id, Long procesoPlantillaId ,String titulo, Boolean asignaTercero, LocalDateTime fechaCreacion){
    
}
