/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.resource;

import com.avianca.model.RepositorioTitulo;
import com.avianca.resource.request.RepositorioTituloRequest;
import com.avianca.resource.response.Pagination;
import com.avianca.resource.response.ResponseCollection;
import com.avianca.service.repositorio.RepositorioTituloServicio;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@Path("/repositorio/titulo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepositorioTituloResource {
    
    private final RepositorioTituloServicio repositorioTituloServicio;
    
    public RepositorioTituloResource(RepositorioTituloServicio repositorioTituloServicio){
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
    public RepositorioTitulo agregar(RepositorioTituloRequest itemRequest){
        
        RepositorioTitulo item = new RepositorioTitulo(null,
                itemRequest.codigo(), 
                itemRequest.titulo(), 
                itemRequest.descripcion(), 
                itemRequest.tieneFechaVencimiento(), null, null);
        
        return repositorioTituloServicio.agregar(1L,item,itemRequest.procesos());
    }
}
