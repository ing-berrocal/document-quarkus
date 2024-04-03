/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource.request;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public record ProcesoCicloRequest (
        Long terceroId,
        LocalDate fechaVencimiento) {
}
