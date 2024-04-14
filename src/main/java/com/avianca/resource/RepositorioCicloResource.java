package com.avianca.resource;

import com.avianca.model.RepositorioData;
import com.avianca.model.RepositorioCiclo;
import com.avianca.resource.response.Pagination;
import com.avianca.resource.response.ResponseCollection;
import com.avianca.service.repositorio.RepositorioServicio;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;


@Path("/repositorio/ciclo")
//@Consumes(MediaType.APPLICATION_JSON)
public class RepositorioCicloResource {
    
    private final RepositorioServicio repositorioServicio;

    public RepositorioCicloResource(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }
    
    @GET
    public ResponseCollection getListado(){        
        return ResponseCollection.of(repositorioServicio.getRepositorio(Long.valueOf("1")),0, Pagination.of(0, 0)) ;
    }
    
    @Path("/{procesoId}")
    @GET
    public ResponseCollection getListadoByProceso(@PathParam("procesoId") Long procesoId){        
        return ResponseCollection.of(repositorioServicio.getRepositorio(Long.valueOf("1")),0, Pagination.of(0, 0)) ;
    }
    
    @POST
    public Response agregar(RepositorioCiclo esquema){
        RepositorioCiclo agregarEsquema = repositorioServicio.agregarEsquema(Long.valueOf("1"), esquema);
        return Response.ok(agregarEsquema).build();
    }
    
    @Path("/{cicloId}/titulo/{repositorioTituloId}")
    @POST
    public Response agregarAProceso(
            @PathParam("cicloId") Long procesoCicloId,
            @PathParam("repositorioTituloId") Long repositorioTituloId,
            MultipartFormDataInput input){
        
        System.out.println("------");
        input.getFormDataMap().forEach((k,v)->{           
            System.out.println(k);
        });                
        System.out.println("------");
        
        ABC abc = new ABC();
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
        input.getFormDataMap().forEach((k,v)->{           
            if("archivo".equalsIgnoreCase(k)){
                v.forEach(i->{
                    try {
                        abc.filename = i.getFileName();
                        abc.formato = i.getMediaType().toString();                    
                        InputStream body = i.getBody();
                        stream.write(body.readAllBytes());
                        //System.out.println(i.getBodyAsString());
                    } catch (IOException ex) { 
                        Logger.getLogger(RepositorioDataResource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }                        
        });

        /*} catch (IOException ex) { 
            Logger.getLogger(RepositorioDataResource.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        RepositorioCiclo esquema = new RepositorioCiclo(null, repositorioTituloId, null,abc.formato,getFechaVencimiento(input));
                
        RepositorioData data = new RepositorioData(abc.formato, stream.toByteArray());
        
        //RepositorioEsquema agregarEsquema = repositorioServicio.agregarEsquema(Long.valueOf("1"), esquema);
        
        repositorioServicio.agregarRepositorio(0L, procesoCicloId, repositorioTituloId, esquema, data);
        
        return Response.ok(null).build();
    }
    
    @Path("/{cicloId}/titulo/{repositorioTituloId}")
    @GET
    public Response dowloadFileProceso(
            @PathParam("cicloId") Long procesoCicloId,
            @PathParam("repositorioTituloId") Long repositorioTituloId){
        
        System.out.println("------");
              
        System.out.println("------");
        
        ABC abc = new ABC();
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        
   

        /*} catch (IOException ex) { 
            Logger.getLogger(RepositorioDataResource.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        return Response.ok(null).build();
    }
    
    private static LocalDate getFechaVencimiento(MultipartFormDataInput input){
        
        try {
            String formatDate = input.getFormDataPart("fecha", String.class, null);
            return LocalDate.parse(formatDate);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(RepositorioCicloResource.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return null;
    }
    
    class ABC{
            String formato;
            String filename;
        }
}
