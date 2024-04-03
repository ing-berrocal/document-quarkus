package com.avianca.persistencia.repository;

import com.avianca.model.RepositorioEsquema;
import com.avianca.persistencia.jpa.repositorio.RepositorioEsquemaEntity;
import com.avianca.persistencia.jpa.repositorio.RepositorioEsquemaPanache;
import jakarta.enterprise.context.ApplicationScoped;
import com.avianca.service.repositorio.RepositorioEsquemaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositorioEsquemaRepositoryImp implements RepositorioEsquemaRepository {

    private final RepositorioEsquemaPanache repositorioEsquemaPanache;

    public RepositorioEsquemaRepositoryImp(
    RepositorioEsquemaPanache repositorioEsquemaPanache) {
        this.repositorioEsquemaPanache = repositorioEsquemaPanache;
    }
    
    @Override
    public List<RepositorioEsquema> getRepositorio(Long empresaId) {
        return this.repositorioEsquemaPanache.streamAll()
                .map(t->new RepositorioEsquema(t.getId(), null,
                        //t.getCodigo()
                        null
                        , t.getFormato(), t.getFechaVencimiento()))
                .toList();
    }

    @Override
    public RepositorioEsquema agregar(Long empresaId, RepositorioEsquema itemParam) {
        
        RepositorioEsquemaEntity entity = new RepositorioEsquemaEntity();
        //entity.setCodigo(itemParam.codigo());
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setFormato(itemParam.formato());
        entity.setFechaVencimiento(itemParam.fechaVencimiento());
        entity.setRepositorioTituloId(itemParam.repositorioTituloId());
        
        repositorioEsquemaPanache.persistAndFlush(entity);
        
        return new RepositorioEsquema(entity.getId(),null, itemParam.codigo(), itemParam.formato(), itemParam.fechaVencimiento());
    }

    @Override
    public Optional<RepositorioEsquema> getById(Long empresaId, Long Id) {
        return this.repositorioEsquemaPanache.findByIdOptional(Id)
                .map(r->new RepositorioEsquema(r.getId(), r.getRepositorioTituloId(),null, r.getFormato(),null));
    }
    
}
