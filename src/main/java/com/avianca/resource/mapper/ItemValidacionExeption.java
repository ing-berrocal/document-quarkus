/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource.mapper;

import com.avianca.model.exception.ItemValidacion;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author DELL
 */
@Provider
public class ItemValidacionExeption implements ExceptionMapper<ItemValidacion>{

    @Override
    public Response toResponse(ItemValidacion e) {
        return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMapeo(e.getMessage())).build();
    }
    
}
