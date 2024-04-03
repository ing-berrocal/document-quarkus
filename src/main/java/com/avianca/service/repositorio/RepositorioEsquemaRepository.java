package com.avianca.service.repositorio;

import java.util.List;
import java.util.Optional;

import com.avianca.model.RepositorioEsquema;

public interface RepositorioEsquemaRepository {
    /**
     * @param empresaId
     * @return
     */
    List<RepositorioEsquema> getRepositorio(Long empresaId);

    RepositorioEsquema agregar(Long empresaId,RepositorioEsquema itemParam);

    Optional<RepositorioEsquema> getById(Long empresaId, Long Id);

}
