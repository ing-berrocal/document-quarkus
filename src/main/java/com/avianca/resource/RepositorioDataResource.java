package com.avianca.resource;

import com.avianca.model.RepositorioData;
import com.avianca.resource.request.RepositorioFormRequest;
import com.avianca.service.repositorio.RepositorioServicio;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;


@Path("/repositorio/data")
//@Consumes(MediaType.APPLICATION_JSON)
public class RepositorioDataResource {
    
    private final RepositorioServicio repositorioServicio;

    public RepositorioDataResource(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }
    
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @POST
    @Path("/{repository_id}")
    public Response agregar(
            //@MultipartForm RepositorioFormRequest request
            //,
            @PathParam("repository_id")
                    Long repoId,
            MultipartFormDataInput input
            ){
       
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
  
        
        input.getFormDataMap().forEach((k,v)->{
           
            if("archivo".equalsIgnoreCase(k)){
                v.forEach(i->{
                try {
                    System.out.println(i.getFileName());
                    System.out.println(i.getMediaType().toString());
                    
                    InputStream body = i.getBody();
                    stream.write(body.readAllBytes());
                    //System.out.println(i.getBodyAsString());
                } catch (IOException ex) { 
                    Logger.getLogger(RepositorioDataResource.class.getName()).log(Level.SEVERE, null, ex);}
            });
            }
            
            
        });

        RepositorioData data = new RepositorioData("", stream.toByteArray());
        
        RepositorioData agregarData = repositorioServicio.agregarData(Long.valueOf("1"), repoId, data);
        /*
        System.out.println(request.getInpit().getName());
        try {
        System.out.println(request.getInpit().getCanonicalPath());
        request.getInpit().
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
         */
        
        return Response.ok(String.format("%s - %s", agregarData.formato(), "")).build();
    }
}
