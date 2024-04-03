/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.Proceso;
import com.avianca.persistencia.jpa.proceso.ProcesoEntity;
import com.avianca.persistencia.jpa.proceso.ProcesoPanache;
import com.avianca.persistencia.jpa.repositorioproceso.RepositorioTituloProcesoPanache;
import com.avianca.service.proceso.ProcesoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoRepositoryImp implements ProcesoRepository{

    private final ProcesoPanache repositoryProcesoPanache;

    public ProcesoRepositoryImp(ProcesoPanache repositoryProcesoPanache,
            RepositorioTituloProcesoPanache repositorioTituloProcesoPanache) {
        this.repositoryProcesoPanache = repositoryProcesoPanache;
    }
    
    @Override
    public List<Proceso> getProcesos() {
        return repositoryProcesoPanache.streamAll(Sort.by("titulo"))
        //.stream("empresaId", Sort.by("codigo"), empresaId)
                .map(t -> new Proceso(t.getId(),t.getTitulo(), t.getAsignaTercero()))
                .toList();
    }

    @Override
    public Proceso crearProceso(Proceso procesoParam) {        
        ProcesoEntity entity = new ProcesoEntity();
        entity.setTitulo(procesoParam.titulo());
        entity.setAsignaTercero(procesoParam.asignaTercero());        
        repositoryProcesoPanache.persist(entity);
        return new Proceso(entity.getId(), entity.getTitulo(), entity.getAsignaTercero());
    }

    @Override
    public Optional<Proceso> getProcesoById(Long empresaId, Long id) {
        return repositoryProcesoPanache.findByIdOptional(id)
                .map(p->new Proceso(p.getId(), p.getTitulo(), p.getAsignaTercero()));
    }

    @Override
    public void modificarProceso(Long id, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Proceso> getProcesos(Long empresaId, Long[] procesos) {
        return Collections.EMPTY_LIST;
    }
    
}
