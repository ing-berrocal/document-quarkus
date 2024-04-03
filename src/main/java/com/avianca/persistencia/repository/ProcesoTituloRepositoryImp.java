/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoTitulo;
import com.avianca.persistencia.jpa.repositorioproceso.RepositorioTituloProcesoEntity;
import com.avianca.persistencia.jpa.repositorioproceso.RepositorioTituloProcesoPanache;
import com.avianca.persistencia.jpa.view.ViewRepositorioTituloProcesoEntity;
import com.avianca.service.procesotitulo.ProcesoTituloRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoTituloRepositoryImp implements ProcesoTituloRepositorio{

    private final EntityManager em;
    
    private final RepositorioTituloProcesoPanache repositorioTituloProcesoPanache;
    
    public ProcesoTituloRepositoryImp(RepositorioTituloProcesoPanache repositorioTituloProcesoPanache,
            EntityManager em){
        this.repositorioTituloProcesoPanache = repositorioTituloProcesoPanache;
        this.em = em;
    }
    
    @Override
    public List<Proceso> getProcesos(Long repositorioTituloId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProcesoTitulo> getRepositorioTitulos(Long empresaId,Long proceso) {
        
        return em.createNamedQuery(ViewRepositorioTituloProcesoEntity.BYPROCESOID,ViewRepositorioTituloProcesoEntity.class)
                .setParameter("empresaId", empresaId)
                .setParameter("procesoId", proceso)
                .getResultStream()
                .map(o->new ProcesoTitulo(
                        o.getRepositorioTituloProcesoPK().getRepositorioTituloId(), 
                        o.getCodigo(), 
                        o.getTitulo(), 
                        o.getFechaCreacion(), Boolean.TRUE)
                ).toList();        
    }

    @Override
    public void registraTituloAProceso(Long repositorioTituloId, Long[] procesos) {
        
        repositorioTituloProcesoPanache.persist(
        Stream.of(procesos).map(proceso-> RepositorioTituloProcesoEntity.getInstance(repositorioTituloId, proceso) )
        );
    }

    @Override
    public void modificarProceso(Long repositorioTituloId, Long[] procesos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeTituloEnRepostorio(Long proceso, Long repositorioTituloId) {
        return repositorioTituloProcesoPanache.find("repositorioTituloProcesoPK.repositorioTituloId = ?1 and repositorioTituloProcesoPK.procesoId= ?2", repositorioTituloId,proceso).count() == 1;
    }
    
}
