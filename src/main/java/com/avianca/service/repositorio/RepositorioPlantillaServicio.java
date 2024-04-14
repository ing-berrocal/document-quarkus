package com.avianca.service.repositorio;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.model.RepositorioPlantilla;
import com.avianca.model.exception.ItemValidacion;
import com.avianca.service.proceso.ProcesoPlantillaRepository;
import com.avianca.service.procesorepositorioplantilla.ProcesoRepositorioPlantillaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RepositorioPlantillaServicio {
    
    private final RepositorioTituloRepositorio repositorioTituloRepositorio;
    private final ProcesoPlantillaRepository procesoRepositorio;
    private final ProcesoRepositorioPlantillaRepository procesoRepositorioPlantillaRepository;
    
    public RepositorioPlantillaServicio(
            RepositorioTituloRepositorio repositorioTituloRepositorio,
            ProcesoPlantillaRepository procesoRepositorio,
            ProcesoRepositorioPlantillaRepository procesoRepositorioPlantillaRepository) {
        this.repositorioTituloRepositorio = repositorioTituloRepositorio;
        this.procesoRepositorio = procesoRepositorio;
        this.procesoRepositorioPlantillaRepository = procesoRepositorioPlantillaRepository;
    }
    
    public List<RepositorioPlantilla> getTitulo(Long empresaId){
        return this.repositorioTituloRepositorio.getTitulos(empresaId);
    }

    @Transactional
    public RepositorioPlantilla agregar(Long empresaId, RepositorioPlantilla repositorio, Long[] procesosId){
        
        if(repositorioTituloRepositorio.obtenerByCodigo(empresaId, repositorio.codigo()).isEmpty()){
            
            List<ProcesoPlantilla> procesos = procesoRepositorio.getProcesos(empresaId, procesosId);
            
            if(procesos.size() != procesos.size()){
            }
            
            RepositorioPlantilla agregado = repositorioTituloRepositorio.agregar(empresaId, repositorio);
            
            procesoRepositorioPlantillaRepository.registraPlantillaProceso(agregado.id(), procesosId);
            
            return agregado;
        }
        throw ItemValidacion.getInstance("Codigo se encuentra registrado");
    }
}
