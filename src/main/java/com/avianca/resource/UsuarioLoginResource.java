package com.avianca.resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.avianca.model.Tercero;
import com.avianca.resource.request.LoginRequest;
import com.avianca.resource.response.AutenticationResponse;
import com.avianca.service.tercero.TerceroService;
import com.avianca.service.usuario.UsuarioService;
import jakarta.annotation.security.PermitAll;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuario")
@PermitAll
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioLoginResource {
    
    private UsuarioService usuarioService;

    public UsuarioLoginResource(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @POST
    public AutenticationResponse login(LoginRequest login){
        return new AutenticationResponse(usuarioService.autenticar(login.email(), login.password()));
    }

    /*@PUT
    @Path("/{id}")
    public Tercero modifcarTercero(@PathParam("id") Long id,Tercero terceroParam){
        return terceroService.modificarTercero(id, terceroParam);
    }*/

}
