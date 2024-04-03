package com.avianca.persistencia.jpa.usuario;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * TerceroPanache
 */
@ApplicationScoped
public class UsuarioPanache implements PanacheRepository<UsuarioEntity> {
}