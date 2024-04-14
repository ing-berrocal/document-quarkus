/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.persistencia.jpa.proceso.ProcesoPlatillaEntity;
import com.avianca.persistencia.jpa.proceso.ProcesoPlatillaPanache;
import com.avianca.persistencia.jpa.procesorepositorio.RepositorioTituloProcesoPanache;
import com.avianca.service.proceso.ProcesoPlantillaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoPlantillaRepositoryImp implements ProcesoPlantillaRepository{

    private final ProcesoPlatillaPanache repositoryProcesoPanache;

    public ProcesoPlantillaRepositoryImp(ProcesoPlatillaPanache repositoryProcesoPanache,
            RepositorioTituloProcesoPanache repositorioTituloProcesoPanache) {
        this.repositoryProcesoPanache = repositoryProcesoPanache;
    }
    
    @Override
    public List<ProcesoPlantilla> getProcesos() {
        return repositoryProcesoPanache.streamAll(Sort.by("titulo"))
        //.stream("empresaId", Sort.by("codigo"), empresaId)
                .map(t -> new ProcesoPlantilla(t.getId(),t.getCodigo(),t.getTitulo(), t.getAsignaTercero()))
                .toList();
    }

    @Override
    public ProcesoPlantilla crearProceso(ProcesoPlantilla procesoParam) {        
        ProcesoPlatillaEntity entity = new ProcesoPlatillaEntity();
        entity.setTitulo(procesoParam.titulo());
        entity.setCodigo(procesoParam.codigo());
        entity.setAsignaTercero(procesoParam.asignaTercero());        
        repositoryProcesoPanache.persist(entity);
        return new ProcesoPlantilla(entity.getId(), procesoParam.codigo(), entity.getTitulo(), entity.getAsignaTercero());
    }

    @Override
    public Optional<ProcesoPlantilla> getProcesoById(Long empresaId, Long id) {
        return repositoryProcesoPanache.findByIdOptional(id)
                .map(p->new ProcesoPlantilla(p.getId(), p.getCodigo(), p.getTitulo(), p.getAsignaTercero()));
    }

    @Override
    public void modificarProceso(Long id, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProcesoPlantilla> getProcesos(Long empresaId, Long[] procesos) {
        return Stream.of(procesos).map(repositoryProcesoPanache::findById)
                .map(m->new ProcesoPlantilla(m.getId(), null,null,null))
                .collect(Collectors.toList());
    }
    
}
