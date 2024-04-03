package com.avianca.persistencia.repository;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Tercero;
import com.avianca.model.TipoDocumento;
import com.avianca.persistencia.jpa.tercero.TerceroEntity;
import com.avianca.persistencia.jpa.tercero.TerceroPanache;
import com.avianca.service.tercero.TerceroRepository;

import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TerceroRepositoryImp implements TerceroRepository {

    private final TerceroPanache terceroPanache;

    public TerceroRepositoryImp(
        TerceroPanache terceroPanache
        ){
        this.terceroPanache = terceroPanache;
    }

    @Override
    public List<Tercero> getTerceros() {
        return terceroPanache.streamAll(Sort.by("documento"))
        .map(t -> new Tercero(
            t.getId(), 
            t.getApellidos(), 
            t.getNombres(), 
            t.getTipoDocumento(), 
            t.getDocumento(), 
            null))
        .toList();
    }

    @Override
    public void crearTercero(Tercero terceroParam) {
        // TODO Auto-generated method stub
        
        TerceroEntity entity = new TerceroEntity();
        
        entity.setTipoDocumento(terceroParam.tipoDocumento());
        entity.setDocumento(terceroParam.documento());
        entity.setApellidos(terceroParam.apellidos());
        entity.setNombres(terceroParam.nombres());
        
        terceroPanache.persistAndFlush(entity);
    }

    @Override
    public boolean existeTercero(TipoDocumento tipoDocumento, String documento) {
        // TODO Auto-generated method stub
        return terceroPanache.count("#"+TerceroEntity.COUNT_TERCERO, Parameters.with("tipoDocumento",tipoDocumento)
        .and("documento", documento)) > 0L;
    }

    @Override
    public Optional<Tercero> getTerceroById(Long id) {
        // TODO Auto-generated method stub
        return terceroPanache.findByIdOptional(id)
        .map(t -> new Tercero(
            t.getId(), 
            t.getApellidos(), 
            t.getNombres(), 
            t.getTipoDocumento(), 
            t.getDocumento(), 
            null));
    }

    @Override
    public void modificarTercero(Long id,Tercero terceroParam) {
        // TODO Auto-generated method stub
        Optional<TerceroEntity> byIdOptional = terceroPanache.findByIdOptional(id);

        byIdOptional.map(t->{
            t.setApellidos(terceroParam.apellidos());
            t.setNombres(terceroParam.nombres());
            return t;   
        }).ifPresent(terceroPanache::persist);
    }
    
}
