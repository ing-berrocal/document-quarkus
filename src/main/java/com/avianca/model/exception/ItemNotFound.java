/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.model.exception;

/**
 *
 * @author DELL
 */
public class ItemNotFound extends RuntimeException{
   
    private ItemNotFound(String mensaje){
        super(mensaje);
    }
    
    public static ItemNotFound getInstance(String mensaje){
        return new ItemNotFound(mensaje);
    }
}
