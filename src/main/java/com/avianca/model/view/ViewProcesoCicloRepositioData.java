/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model.view;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public record ViewProcesoCicloRepositioData(
        Long id,
        String formato,
        LocalDate fechaVencimiento) {

    public static ViewProcesoCicloRepositioData getInstance(Long id,
        String formato,
        LocalDate fechaVencimiento) {
        return new ViewProcesoCicloRepositioData(id,formato,fechaVencimiento);
    }
    
}
