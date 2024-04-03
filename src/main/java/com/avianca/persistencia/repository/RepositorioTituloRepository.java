/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.Proceso;
import com.avianca.model.RepositorioTitulo;
import com.avianca.persistencia.jpa.repositorio.RepositorioTituloEntity;
import com.avianca.persistencia.jpa.repositorio.RepositorioTituloPanache;
import com.avianca.service.repositorio.RepositorioTituloRepositorio;
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

    private final RepositorioTituloPanache repositorioTituloPanache;
    
    public RepositorioTituloRepository(RepositorioTituloPanache repositorioTituloPanache) {
        this.repositorioTituloPanache = repositorioTituloPanache;
    }
    
    @Override
    public List<RepositorioTitulo> getTitulos(Long empresaId) {
        return repositorioTituloPanache.stream("empresaId", Sort.by("codigo"), empresaId)
                .map(t -> new RepositorioTitulo(t.getId(),t.getCodigo(), 
                        t.getTitulo(), 
                        t.getDescripcion(), 
                        t.getTieneFechaVencimiento(),
                t.getFechaCreacion(),
                        new Proceso[]{new Proceso(1L, "Hola", Boolean.TRUE)}))
                .toList();
    }

    @Override
    public RepositorioTitulo agregar(Long empresaId, RepositorioTitulo item) {
        
        RepositorioTituloEntity entity = new RepositorioTituloEntity();
        entity.setEmpresaId(empresaId);
        entity.setCodigo(item.codigo());
        entity.setTitulo(item.titulo());
        entity.setDescripcion(item.descripcion());
        entity.setTieneFechaVencimiento(item.tieneFechaVencimiento());
        entity.setFechaCreacion(LocalDateTime.now());
        repositorioTituloPanache.persist(entity);
        
        return new RepositorioTitulo(entity.getId(),null,null,null,null,null,null);
    }

    @Override
    public Optional<RepositorioTitulo> obtenerById(Long empresaId, Long id, String codigo){
        return repositorioTituloPanache.findByIdOptional(id)//.find("empresaId = ?1 and codigo = ?2", empresaId,codigo)
                //.firstResultOptional()
                .map(t -> new RepositorioTitulo(t.getId(),t.getCodigo(), 
                        t.getTitulo(), 
                        t.getDescripcion(), 
                        t.getTieneFechaVencimiento(),
                t.getFechaCreacion(),
                new Proceso[0]));
                
    }
    
}
