/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.Usuario;
import com.avianca.persistencia.jpa.usuario.UsuarioPanache;
import com.avianca.service.usuario.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class UsuarioRepositoryImp implements UsuarioRepository{

    private final UsuarioPanache usuarioPanache;

    public UsuarioRepositoryImp(UsuarioPanache usuarioPanache) {
        this.usuarioPanache = usuarioPanache;
    }
    @Override
    public Optional<Usuario> findByEmail(String email) {
        
        Usuario usuario = new Usuario();
        
        usuario.setEmail("email@email.com");
        
        return Optional.of(usuario);
    }
    
}
