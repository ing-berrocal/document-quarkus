/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource.mapper;

import com.avianca.model.exception.ItemNotFound;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 *
 * @author DELL
 */
@Provider
public class NotFoundItemExeption implements ExceptionMapper<ItemNotFound>{

    @Override
    public Response toResponse(ItemNotFound e) {
        return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMapeo(e.getMessage())).build();
    }
    
}
