/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.service.usuario;

import com.avianca.model.Usuario;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

import io.smallrye.jwt.build.Jwt;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import org.eclipse.microprofile.jwt.Claims;
/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public String autenticar(String email, String passowrd){
        
        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(email);
        
        if(optUsuario.isEmpty()){
            
        }
        
        optUsuario.get();
        
        String token =
           Jwt
             .issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups(new HashSet<>(Arrays.asList("User", "Admin"))) 
             .claim(Claims.birthdate.name(), "2001-07-13") 
             .claim("nickName", "Houdini!!!")
                   .expiresIn(Duration.ofDays(1L))
                   .jws()
                   //algorithm(SignatureAlgorithm.RS512)
                   .sign()
                    //.jwe().encrypt()
                ;
        
        System.out.println(token);
        
        return token;
    }
}
