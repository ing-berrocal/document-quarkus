/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.service.proceso;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.model.ProcesoTitulo;
import com.avianca.model.exception.ItemNotFound;
import com.avianca.service.procesorepositorioplantilla.ProcesoRepositorioPlantillaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoPlantillaServicio {

    private final ProcesoPlantillaRepository repository;
    private final ProcesoRepositorioPlantillaRepository procesoTituloRepositorio;
    
    public ProcesoPlantillaServicio(ProcesoPlantillaRepository repository,
            ProcesoRepositorioPlantillaRepository procesoTituloRepositorio) {
        this.repository = repository;
        this.procesoTituloRepositorio = procesoTituloRepositorio;
    }
    
    public List<ProcesoPlantilla> getProcesos(){
        return repository.getProcesos();
    }
    
    public ProcesoPlantilla getProcesoById(Long empresaId, Long id){
        return repository.getProcesoById(empresaId, id)
                .orElseThrow(()->ItemNotFound.getInstance("No existe plantilla de proceso"));
    }
    
    public List<ProcesoTitulo> getRepositorios(Long procesoId){
        return procesoTituloRepositorio.getRepositorioTitulos(1L, procesoId);
    }
    
    @Transactional
    public ProcesoPlantilla agregar(Long empresaId, ProcesoPlantilla proceso){
                
        return repository.crearProceso(proceso);
    }
    
}
