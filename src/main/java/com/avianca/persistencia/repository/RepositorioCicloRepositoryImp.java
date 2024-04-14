package com.avianca.persistencia.repository;

import com.avianca.model.RepositorioCiclo;
import com.avianca.persistencia.jpa.repositorio.RepositorioCicloEntity;
import com.avianca.persistencia.jpa.repositorio.RepositorioCicloPanache;
import com.avianca.service.repositorio.RepositorioCicloRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepositorioCicloRepositoryImp implements RepositorioCicloRepository {

    private final RepositorioCicloPanache repositorioEsquemaPanache;

    public RepositorioCicloRepositoryImp(
    RepositorioCicloPanache repositorioEsquemaPanache) {
        this.repositorioEsquemaPanache = repositorioEsquemaPanache;
    }
    
    @Override
    public List<RepositorioCiclo> getRepositorio(Long empresaId) {
        return this.repositorioEsquemaPanache.streamAll()
                .map(t->new RepositorioCiclo(t.getId(), null,
                        //t.getCodigo()
                        null
                        , t.getFormato(), t.getFechaVencimiento()))
                .toList();
    }

    @Override
    public RepositorioCiclo agregar(Long empresaId, RepositorioCiclo itemParam) {
        
        RepositorioCicloEntity entity = new RepositorioCicloEntity();
        //entity.setCodigo(itemParam.codigo());
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setFormato(itemParam.formato());
        entity.setFechaVencimiento(itemParam.fechaVencimiento());
        entity.setRepositorioPlantillaId(itemParam.repositorioPlantillaId());
        
        repositorioEsquemaPanache.persistAndFlush(entity);
        
        return new RepositorioCiclo(entity.getId(),null, itemParam.codigo(), itemParam.formato(), itemParam.fechaVencimiento());
    }

    @Override
    public Optional<RepositorioCiclo> getById(Long empresaId, Long Id) {
        return this.repositorioEsquemaPanache.findByIdOptional(Id)
                .map(r->new RepositorioCiclo(r.getId(), r.getRepositorioPlantillaId(),null, r.getFormato(),null));
    }
    
}
