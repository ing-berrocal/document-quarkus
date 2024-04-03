/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource.response;

/**
 *
 * @author DELL
 */
public record Pagination(Integer pages, Integer page) {
    public static Pagination of(Integer pages, Integer page){
        return new Pagination(pages, page);
    }
}
