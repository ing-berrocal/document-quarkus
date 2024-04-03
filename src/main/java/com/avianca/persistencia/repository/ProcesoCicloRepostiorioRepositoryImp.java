/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.ProcesoCiclo;
import com.avianca.model.ProcesoTitulo;
import com.avianca.persistencia.jpa.proceso.ProcesoCicloRepositorioEntity;
import com.avianca.persistencia.jpa.proceso.ProcesoCicloRepositorioPanache;
import com.avianca.service.proceso.ProcesoCicloRepostiorioRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author DELL
 */
@ApplicationScoped
public class ProcesoCicloRepostiorioRepositoryImp implements ProcesoCicloRepostiorioRepository{

    private final ProcesoCicloRepositorioPanache procesoCicloRepositorioPanache;

    public ProcesoCicloRepostiorioRepositoryImp(ProcesoCicloRepositorioPanache procesoCicloRepositorioPanache) {
        this.procesoCicloRepositorioPanache = procesoCicloRepositorioPanache;
    }
    
    
    @Override
    public void agregarProcesoCicloRepositorioTitulo(ProcesoCiclo procesoCiclo, List<ProcesoTitulo> repositorioTitulos) {
    
        LocalDateTime now = LocalDateTime.now();
        
        repositorioTitulos.stream()
                .map(pt->{
                    ProcesoCicloRepositorioEntity entity = new ProcesoCicloRepositorioEntity();
                    
                    entity.setProcesoCicloId(procesoCiclo.id());
                    entity.setRepositorioTituloId(pt.tituloId());
                    entity.setFechaCreacion(now);
                    
                    return entity;
                }).forEach(procesoCicloRepositorioPanache::persistAndFlush);
    }

    @Override
    public int relacionarCicloRepoTituloData(Long procesoCicloId, Long repositorioTituloId, Long repositorioId){
        return procesoCicloRepositorioPanache.update(ProcesoCicloRepositorioEntity.OBTENER_POR_PROCESOS,
                Parameters.with("procesoCicloId", procesoCicloId)
                        .and("repositorioTituloId", repositorioTituloId)
                        .and("repositorioId", repositorioId).map());
    }
    
}
