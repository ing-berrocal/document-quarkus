/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource;

import com.avianca.model.RepositorioPlantilla;
import com.avianca.resource.request.RepositorioPlantillaRequest;
import com.avianca.resource.response.Pagination;
import com.avianca.resource.response.ResponseCollection;
import com.avianca.service.repositorio.RepositorioPlantillaServicio;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author Lenovo
 */
@Path("/repositorio/plantilla")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepositorioPlantillaResource {
    
    private final RepositorioPlantillaServicio repositorioTituloServicio;
    
    public RepositorioPlantillaResource(RepositorioPlantillaServicio repositorioTituloServicio){
        this.repositorioTituloServicio = repositorioTituloServicio;
    }
    
    @GET
    public ResponseCollection getListado(){        
        return ResponseCollection.of(repositorioTituloServicio.getTitulo(1L),0, Pagination.of(0, 0)) ;
    }
    
    @GET
    public ResponseCollection getProcesoPorTitulo(Long empresaId,Long repositorioId){
        return ResponseCollection.of(repositorioTituloServicio.getTitulo(1L),0, Pagination.of(0, 0)) ;
    }

    @POST
    public RepositorioPlantilla agregar(RepositorioPlantillaRequest itemRequest){
        
        RepositorioPlantilla item = new RepositorioPlantilla(null,
                itemRequest.codigo(), 
                itemRequest.titulo(), 
                itemRequest.descripcion(), 
                itemRequest.tieneFechaVencimiento(), null, null);
        
        return repositorioTituloServicio.agregar(1L,item,itemRequest.procesos());
    }
}
