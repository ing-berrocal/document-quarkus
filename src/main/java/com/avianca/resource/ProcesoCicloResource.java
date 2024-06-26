/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource;

import com.avianca.model.ProcesoCiclo;
import com.avianca.model.exception.ItemNotFound;
import com.avianca.resource.request.ProcesoCicloRequest;
import com.avianca.resource.response.Pagination;
import com.avianca.resource.response.ResponseCollection;
import com.avianca.resource.response.ResponseObject;
import com.avianca.service.proceso.ProcesoCicloServicio;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Lenovo
 */
@Path("/proceso/ciclo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcesoCicloResource {
    
    @Inject
    private ProcesoCicloServicio procesoCicloServicio;
    
    @GET
    public ResponseCollection getListado(){
        return ResponseCollection.of(procesoCicloServicio.getProcesos(),0, Pagination.of(0, 0)) ;
    }
    
    @GET
    @Path("/{id}")
    public ResponseObject getProcesoById(@PathParam("id") Long procesoId){
        return new ResponseObject(procesoCicloServicio.getProcesoById(procesoId, 0L).orElseThrow(()->ItemNotFound.getInstance("No existe proceso-ciclo")));
    }
    
    @GET
    @Path("/{id}/repositorios")
    public ResponseCollection getRepositorios(@PathParam("id") Long cicloId){        
        return ResponseCollection.of(procesoCicloServicio.getRepositorios(cicloId),0, Pagination.of(0, 0)) ;
    }
    
    @POST
    public Response crearProceso(ProcesoCicloRequest request){
        
        ProcesoCiclo procesoCiclo = new ProcesoCiclo(null, 
                request.procesoPlantillaId(), 
                request.titulo(), null, null);
        
        procesoCicloServicio.agregar(1L,procesoCiclo);
        return Response.accepted().build();
    }
    
    @PUT
    @Path("/{cicloId}/repositorio/{repositorioId}")
    public Response agregarRepositorio(@PathParam("cicloId") Long cicloId,
            @PathParam("repositorioId") Long repositorioId){
        procesoCicloServicio.agregarRepositorio(1L, cicloId, repositorioId, null);
        return Response.accepted().build();
    }
}
