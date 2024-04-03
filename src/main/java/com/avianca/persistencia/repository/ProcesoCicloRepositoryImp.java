/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoCiclo;
import com.avianca.persistencia.jpa.proceso.ProcesoCicloEntity;
import com.avianca.persistencia.jpa.proceso.ProcesoCicloPanache;
import com.avianca.persistencia.jpa.proceso.ProcesoCicloRepositorioPanache;
import com.avianca.persistencia.jpa.proceso.ProcesoEntity;
import com.avianca.persistencia.jpa.repositorioproceso.RepositorioProcesoCicloEntity;
import com.avianca.persistencia.jpa.repositorioproceso.RepositorioProcesoCicloPanache;
import com.avianca.service.proceso.ProcesoCicloRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoCicloRepositoryImp implements ProcesoCicloRepository{

    private final ProcesoCicloPanache procesoCicloPanache;
    private final RepositorioProcesoCicloPanache repositorioProcesoCicloPanache;
    private final ProcesoCicloRepositorioPanache procesoCicloRepositorioPanache;

    public ProcesoCicloRepositoryImp(ProcesoCicloPanache procesoCicloPanache,
            RepositorioProcesoCicloPanache repositorioProcesoCicloPanache,
            ProcesoCicloRepositorioPanache procesoCicloRepositorioPanache) {
        this.procesoCicloPanache = procesoCicloPanache;
        this.repositorioProcesoCicloPanache = repositorioProcesoCicloPanache;
        this.procesoCicloRepositorioPanache = procesoCicloRepositorioPanache;
    }
    
    @Override
    public ProcesoCiclo crearCiclo(Proceso proceso) {
        
        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity.setId(proceso.id());
        
        ProcesoCicloEntity entity = new ProcesoCicloEntity();
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setProcesoEntity(procesoEntity);
        entity.setTerminado(Boolean.FALSE);
        //entity.setFechaValidoHasta(proceso.);
        
        procesoCicloPanache.persist(entity);  
        
        return new ProcesoCiclo(entity.getId(), null, null, null, null);
    }

    @Override
    public void agregarRepositorio(ProcesoCiclo procesoCiclo, Long repositorioId) {
        
        RepositorioProcesoCicloEntity repositorioProcesoCicloEntity = RepositorioProcesoCicloEntity.getInstance(repositorioId, 
                procesoCiclo.id());
        
        repositorioProcesoCicloPanache.persistAndFlush(repositorioProcesoCicloEntity);
    }

    @Override
    public Optional<ProcesoCiclo> getProcesoCicloById(Long empresaId, Long id) {
        return procesoCicloPanache.findByIdOptional(id).map(p->new ProcesoCiclo(id, p.getProcesoEntity().getId(),null,null,null));
    }
    
}
