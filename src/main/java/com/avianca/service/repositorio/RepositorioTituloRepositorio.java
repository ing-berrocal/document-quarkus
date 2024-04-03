/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avianca.service.repositorio;

import com.avianca.model.RepositorioTitulo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
public interface RepositorioTituloRepositorio {
    public List<RepositorioTitulo> getTitulos(Long empresaId);
    public RepositorioTitulo agregar(Long empresaId, RepositorioTitulo item);
    public Optional<RepositorioTitulo> obtenerById(Long empresaId, Long id, String codigo);
}
