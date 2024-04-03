/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource;

import com.avianca.model.Proceso;
import com.avianca.resource.response.Pagination;
import com.avianca.resource.response.ResponseCollection;
import com.avianca.resource.response.ResponseObject;
import com.avianca.service.proceso.ProcesoServicio;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author Lenovo
 */
@Path("/proceso")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcesoResource {
    
    @Inject
    private ProcesoServicio procesoServicio;
    
    @GET
    public ResponseCollection getListado(){
        return ResponseCollection.of(procesoServicio.getProcesos(),0, Pagination.of(0, 0)) ;
    }
    
    @GET
    @Path("/{id}")
    public ResponseObject getProcesoById(@PathParam("id") Long procesoId){
        return new ResponseObject(procesoServicio.getProcesoById(0L, procesoId));
    }
    
    @GET
    @Path("/{id}/repositorios")
    public ResponseCollection getRepositorios(@PathParam("id") Long procesoId){
        return ResponseCollection.of(procesoServicio.getRepositorios(procesoId),0, Pagination.of(0, 0)) ;
    }
    
    @POST
    public Proceso crearTercero(Proceso procesoParam){
        return procesoServicio.agregar(null,procesoParam);
    }
}
