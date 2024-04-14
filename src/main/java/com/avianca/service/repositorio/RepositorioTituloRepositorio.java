/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avianca.service.repositorio;

import com.avianca.model.RepositorioPlantilla;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
public interface RepositorioTituloRepositorio {
    public List<RepositorioPlantilla> getTitulos(Long empresaId);
    public RepositorioPlantilla agregar(Long empresaId, RepositorioPlantilla item);
    public Optional<RepositorioPlantilla> obtenerById(Long empresaId, Long id, String codigo);
    public Optional<RepositorioPlantilla> obtenerByCodigo(Long empresaId, String codigo);
}
