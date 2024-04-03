package com.avianca.tercero.mock;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Tercero;
import com.avianca.model.TipoDocumento;
import com.avianca.service.tercero.TerceroRepository;

import io.quarkus.test.Mock;

public class TerceroRepositoryImp implements TerceroRepository {

    @Override
    public List<Tercero> getTerceros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTerceros'");
    }

    @Override
    public void crearTercero(Tercero terceroParam) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearTercero'");
    }

    @Override
    public boolean existeTercero(TipoDocumento tipoDocumento, String documento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeTercero'");
    }

    @Override
    public Optional<Tercero> getTerceroById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTerceroById'");
    }

    @Override
    public void modificarTercero(Long id, Tercero terceroParam) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarTercero'");
    }

        
}
