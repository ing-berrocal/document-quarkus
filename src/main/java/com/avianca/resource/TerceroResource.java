package com.avianca.resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.avianca.model.Tercero;
import com.avianca.service.tercero.TerceroService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claim;

@Path("/tercero")
@RolesAllowed({ "User", "Admin" }) 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TerceroResource {
    
    @Inject
    @Claim(value = "nickName")
    String nickName; 
    
    private TerceroService terceroService;

    public TerceroResource(TerceroService terceroService){
        this.terceroService = terceroService;
    }

    @Operation(summary = "Return a list of Terceros", operationId = "getTerceros")
    @APIResponse(
        responseCode = "202",
        headers = { 
            @Header( 
                name = "id",
                description = "ID of the created entity",
                schema = @Schema(implementation = Integer.class)
            ),
        },
        description = "Return of terceros succeced"
    )
    @GET
    public List<Tercero> getListado(){
        return terceroService.getTerceros();
    }

    @Operation(summary = "Creacion de Terceros", operationId = "crearTercero")
    @APIResponse(
        responseCode = "202",
        headers = { 
            @Header( 
                name = "id",
                description = "ID of the created entity",
                schema = @Schema(implementation = Integer.class)
            ),
        },
        description = "Return of terceros succeced"
    )
    @POST
    public Tercero crearTercero(Tercero terceroParam){
        return terceroService.crearTercero(terceroParam);
    }

    @PUT
    @Path("/{id}")
    public Tercero modifcarTercero(@PathParam("id") Long id,Tercero terceroParam){
        return terceroService.modificarTercero(id, terceroParam);
    }

}
