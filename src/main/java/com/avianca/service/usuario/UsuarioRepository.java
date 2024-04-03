/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avianca.service.usuario;

import com.avianca.model.Usuario;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
public interface UsuarioRepository {

    public Optional<Usuario> findByEmail(String email);
    
}
