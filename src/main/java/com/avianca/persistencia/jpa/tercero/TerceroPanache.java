package com.avianca.persistencia.jpa.tercero;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * TerceroPanache
 */
@ApplicationScoped
public class TerceroPanache implements PanacheRepository<TerceroEntity> {
}