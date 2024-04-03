/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource.response;

import java.util.Collection;

/**
 *
 * @author DELL
 */
public record ResponseCollection(Collection<?> data, Integer size, Pagination page) {
    public static ResponseCollection of(Collection<?> data, Integer size, Pagination page){
        return new ResponseCollection(data, size, page);
    }
}
