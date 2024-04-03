/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.RepositorioData;
import com.avianca.persistencia.jpa.repositorio.RepositorioDataEntity;
import com.avianca.persistencia.jpa.repositorio.RepositorioDataPanache;
import com.avianca.service.repositorio.RepositorioDataRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class RepositorioDataRepositoryImp implements RepositorioDataRepository{

    private final RepositorioDataPanache repositorioDataPanache;

    public RepositorioDataRepositoryImp(RepositorioDataPanache repositorioDataPanache) {
        this.repositorioDataPanache = repositorioDataPanache;
    }
    @Override
    public RepositorioData agregar(Long repositorioId, RepositorioData itemParam) {
        
        RepositorioDataEntity entity = new RepositorioDataEntity();
        entity.setId(repositorioId);
        entity.setData(itemParam.data());
        entity.setFormato(itemParam.formato());
        entity.setFechaCreacion(LocalDateTime.now());
        
        repositorioDataPanache.persistAndFlush(entity);
        
        return itemParam;
    }

    @Override
    public Optional<RepositorioData> getById(Long repositorioId) {
        return repositorioDataPanache.findByIdOptional(repositorioId)
                .map(d->new RepositorioData(d.getFormato(), d.getData()));
    }
    
}
