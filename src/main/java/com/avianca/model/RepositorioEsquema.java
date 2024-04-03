/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public record RepositorioEsquema(
    Long id,    
    Long repositorioTituloId,    
    String codigo,
    String formato,
    LocalDate fechaVencimiento){

}
