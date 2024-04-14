/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.model.RepositorioPlantilla;
import com.avianca.persistencia.jpa.repositorio.RepositorioPlantillaEntity;
import com.avianca.persistencia.jpa.repositorio.RepositorioPlantillaPanache;
import com.avianca.service.repositorio.RepositorioTituloRepositorio;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class RepositorioTituloRepository implements RepositorioTituloRepositorio{

    private final RepositorioPlantillaPanache repositorioTituloPanache;
    
    public RepositorioTituloRepository(RepositorioPlantillaPanache repositorioTituloPanache) {
        this.repositorioTituloPanache = repositorioTituloPanache;
    }
    
    @Override
    public List<RepositorioPlantilla> getTitulos(Long empresaId) {
        return repositorioTituloPanache.stream("empresaId", Sort.by("codigo"), empresaId)
                .map(t -> new RepositorioPlantilla(t.getId(),t.getCodigo(), 
                        t.getTitulo(), 
                        t.getDescripcion(), 
                        t.getTieneFechaVencimiento(),
                t.getFechaCreacion(),
                        new ProcesoPlantilla[]{new ProcesoPlantilla(1L, null, "Hola", Boolean.TRUE)}))
                .toList();
    }

    @Override
    public RepositorioPlantilla agregar(Long empresaId, RepositorioPlantilla item) {
        
        RepositorioPlantillaEntity entity = new RepositorioPlantillaEntity();
        entity.setEmpresaId(empresaId);
        entity.setCodigo(item.codigo());
        entity.setTitulo(item.titulo());
        entity.setDescripcion(item.descripcion());
        entity.setTieneFechaVencimiento(item.tieneFechaVencimiento());
        entity.setFechaCreacion(LocalDateTime.now());
        repositorioTituloPanache.persist(entity);
        
        return new RepositorioPlantilla(entity.getId(),null,null,null,null,null,null);
    }

    @Override
    public Optional<RepositorioPlantilla> obtenerById(Long empresaId, Long id, String codigo){
        return repositorioTituloPanache.findByIdOptional(id)//.find("empresaId = ?1 and codigo = ?2", empresaId,codigo)
                //.firstResultOptional()
                .map(t -> new RepositorioPlantilla(t.getId(),t.getCodigo(), 
                        t.getTitulo(), 
                        t.getDescripcion(), 
                        t.getTieneFechaVencimiento(),
                t.getFechaCreacion(),
                new ProcesoPlantilla[0]));
                
    }

    @Override
    public Optional<RepositorioPlantilla> obtenerByCodigo(Long empresaId, String codigo) {
        return repositorioTituloPanache.find("codigo = :codigo", Parameters.with("codigo", codigo)).firstResultOptional()
                .map(t -> new RepositorioPlantilla(t.getId(),t.getCodigo(), 
                        t.getTitulo(), 
                        t.getDescripcion(), 
                        t.getTieneFechaVencimiento(),
                t.getFechaCreacion(),
                new ProcesoPlantilla[0]));
               
    }
    
}
