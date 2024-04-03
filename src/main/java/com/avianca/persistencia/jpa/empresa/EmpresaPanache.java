package com.avianca.persistencia.jpa.empresa;

import com.avianca.model.Empresa;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmpresaPanache implements PanacheRepository<Empresa>{
    
}
