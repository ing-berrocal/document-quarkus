/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.service.proceso;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoTitulo;
import com.avianca.service.procesotitulo.ProcesoTituloRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoServicio {

    private final ProcesoRepository repository;
    private final ProcesoTituloRepositorio procesoTituloRepositorio;
    
    public ProcesoServicio(ProcesoRepository repository,
            ProcesoTituloRepositorio procesoTituloRepositorio) {
        this.repository = repository;
        this.procesoTituloRepositorio = procesoTituloRepositorio;
    }
    
    public List<Proceso> getProcesos(){
        return repository.getProcesos();
    }
    
    public Proceso getProcesoById(Long empresaId, Long id){
        return repository.getProcesoById(empresaId, id)
                .orElseThrow();
    }
    
    public List<ProcesoTitulo> getRepositorios(Long procesoId){
        return procesoTituloRepositorio.getRepositorioTitulos(1L, procesoId);
    }
    
    @Transactional
    public Proceso agregar(Long empresaId, Proceso proceso){
                
        return repository.crearProceso(proceso);
    }
    
}
