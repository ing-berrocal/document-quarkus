package com.avianca.service.tercero;

import java.util.List;
import java.util.Optional;
import com.avianca.model.Tercero;
import com.avianca.model.TipoDocumento;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TerceroService {
    
    private final TerceroRepository terceroRepository;

    public TerceroService(
        TerceroRepository terceroRepository
    ){
        this.terceroRepository = terceroRepository;
    }

    @PostConstruct 
    void init() {
        /*terceroList.add(new Tercero("1001", 
        "Berrocal Anaya", 
        "Daniel Antonio", 
        TipoDocumento.CC, 
        "1067874099", null));*/
    }

    @PreDestroy 
    void destroy() {
      // ...
    }

    public List<Tercero> getTerceros(){
        return terceroRepository.getTerceros();
    }

    @Transactional
    public Tercero crearTercero(Tercero terceroParam){
        if(!existeTercero(terceroParam.tipoDocumento(),terceroParam.documento())){
            terceroRepository.crearTercero(terceroParam);
        }else{
            throw new RuntimeException("Tercero registrado en el sistema");
        }
        return terceroParam;
    }

    private boolean existeTercero(TipoDocumento tipoDocumento, String documento) {
        return terceroRepository.existeTercero(tipoDocumento,documento);
    }

    @Transactional
    public Tercero modificarTercero(Long id,Tercero terceroParam) {

        Optional<Tercero> terceroById = terceroRepository.getTerceroById(id);

        if(!terceroById.isPresent()){
            throw new RuntimeException("Tercero no registrado en el sistema");
        }

        terceroById.ifPresent(t -> {
            terceroRepository.modificarTercero(id,terceroParam);
        });

        return terceroParam;
    }

    
}
