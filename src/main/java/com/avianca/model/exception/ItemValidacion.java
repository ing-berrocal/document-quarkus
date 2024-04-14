/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model.exception;

/**
 *
 * @author DELL
 */
public class ItemValidacion extends RuntimeException{
   
    private ItemValidacion(String mensaje){
        super(mensaje);
    }
    
    public static ItemValidacion getInstance(String mensaje){
        return new ItemValidacion(mensaje);
    }
}
