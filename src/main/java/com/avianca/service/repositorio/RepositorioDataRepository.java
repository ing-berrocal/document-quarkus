package com.avianca.service.repositorio;

import java.util.Optional;

import com.avianca.model.RepositorioData;

public interface RepositorioDataRepository {

    RepositorioData agregar(Long repositorioId,RepositorioData itemParam);

    Optional<RepositorioData> getById(Long repositorioId);
    
}
