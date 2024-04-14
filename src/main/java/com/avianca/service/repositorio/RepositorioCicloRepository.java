package com.avianca.service.repositorio;

import java.util.List;
import java.util.Optional;

import com.avianca.model.RepositorioCiclo;

public interface RepositorioCicloRepository {
    /**
     * @param empresaId
     * @return
     */
    List<RepositorioCiclo> getRepositorio(Long empresaId);

    RepositorioCiclo agregar(Long empresaId,RepositorioCiclo itemParam);

    Optional<RepositorioCiclo> getById(Long empresaId, Long Id);

}
