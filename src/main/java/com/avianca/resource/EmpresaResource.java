package com.avianca.resource;

import java.util.List;

import com.avianca.model.Empresa;
import com.avianca.model.Tercero;
import com.avianca.service.empresa.EmpresaService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/empresa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpresaResource {
    
    private EmpresaService empresaService;

    public EmpresaResource(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GET
    public List<Empresa> getListado(){
        return empresaService.getEmpresas();
    }
}
