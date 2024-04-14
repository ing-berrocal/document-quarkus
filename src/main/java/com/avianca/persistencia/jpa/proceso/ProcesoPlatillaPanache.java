package com.avianca.persistencia.jpa.proceso;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesoPlatillaPanache implements PanacheRepository<ProcesoPlatillaEntity>{
    
}
