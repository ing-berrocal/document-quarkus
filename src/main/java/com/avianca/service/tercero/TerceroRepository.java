package com.avianca.service.tercero;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Tercero;
import com.avianca.model.TipoDocumento;

public interface TerceroRepository {
    List<Tercero> getTerceros();

    void crearTercero(Tercero terceroParam);

    boolean existeTercero(TipoDocumento tipoDocumento, String documento);

    Optional<Tercero> getTerceroById(Long id);

    void modificarTercero(Long id,Tercero terceroParam);
}
