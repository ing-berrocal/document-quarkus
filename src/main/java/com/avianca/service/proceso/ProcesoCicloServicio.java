/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.service.proceso;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.model.ProcesoCiclo;
import com.avianca.model.ProcesoTitulo;
import com.avianca.model.RepositorioCiclo;
import com.avianca.model.exception.ItemValidacion;
import com.avianca.model.view.ViewProcesoCicloRepositio;
import com.avianca.model.view.ViewProcesoCiclo;
import com.avianca.service.procesorepositorioplantilla.ProcesoRepositorioPlantillaRepository;
import com.avianca.service.repositorio.RepositorioCicloRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class ProcesoCicloServicio {

    private final ProcesoPlantillaRepository repository;
    private final ProcesoCicloRepository procesoCicloRepository;
    private final ProcesoRepositorioPlantillaRepository procesoRepositorioPlantillaRepository;
    private final RepositorioCicloRepository repositorioEsquemaRepository;
    private final ViewProcesoCicloRepository viewProcesoCicloRepository;
    private final ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository;
    private final ViewProcesoCicloRepositorioRepository viewProcesoCicloRepositorioRepository;
    
    public ProcesoCicloServicio(ProcesoPlantillaRepository repository,
            ProcesoCicloRepository procesoCicloRepository,
            ProcesoRepositorioPlantillaRepository procesoRepositorioPlantillaRepository,
            RepositorioCicloRepository repositorioEsquemaRepository,
            ViewProcesoCicloRepository viewProcesoCicloRepository,
            ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository,
            ViewProcesoCicloRepositorioRepository viewProcesoCicloRepositorioRepository) {
        this.repository = repository;
        this.procesoCicloRepository = procesoCicloRepository;
        this.procesoRepositorioPlantillaRepository = procesoRepositorioPlantillaRepository;
        this.repositorioEsquemaRepository = repositorioEsquemaRepository;
        this.viewProcesoCicloRepository = viewProcesoCicloRepository;
        this.procesoCicloRepostiorioRepository = procesoCicloRepostiorioRepository;
        this.viewProcesoCicloRepositorioRepository = viewProcesoCicloRepositorioRepository;
    }
    
    @Transactional
    public ProcesoCiclo agregar(Long empresaId, ProcesoCiclo procesoCicloCreacion){
        
        Optional<ProcesoPlantilla> procesoById = repository.getProcesoById(empresaId, procesoCicloCreacion.procesoPlantillaId());
        
        if(procesoById.isEmpty()){
            throw ItemValidacion.getInstance("No existe proceso-plantilla");
        }
                
        List<ProcesoTitulo> repositorioTitulos = procesoRepositorioPlantillaRepository.getRepositorioTitulos(empresaId, procesoCicloCreacion.procesoPlantillaId());
        
        if(repositorioTitulos.isEmpty()){
            throw ItemValidacion.getInstance("No existe repositorios para proceso");
        }                
        
        ProcesoCiclo cicloCreado = procesoCicloRepository.crearCiclo(procesoCicloCreacion);
        
        procesoCicloRepostiorioRepository.agregarProcesoCicloRepositorioTitulo(cicloCreado, repositorioTitulos);
        
        return cicloCreado;
        
    }
    
    @Transactional
    public void agregarRepositorio(Long empresaId, Long procesoCicloId, Long repositorioId, String codigoRepositorio){
        
        Optional<ProcesoCiclo> procesoCicloById = procesoCicloRepository.getProcesoCicloById(empresaId,procesoCicloId);
        
        if(procesoCicloById.isEmpty()){
            throw new RuntimeException("No existe ciclo");
        }
        
        ProcesoCiclo procesoCiclo = procesoCicloById.get();
        
        Optional<RepositorioCiclo> byId = repositorioEsquemaRepository.getById(empresaId, repositorioId);
        
        if(byId.isEmpty()){
            throw new RuntimeException("No existe repositorio");
        }
        
        RepositorioCiclo repositorioEsquema = byId.get();
        
        if(procesoRepositorioPlantillaRepository.existeTituloEnRepostorio(procesoCiclo.procesoPlantillaId(), repositorioEsquema.repositorioPlantillaId())){
            procesoCicloRepository.agregarRepositorio(procesoCicloById.get(), repositorioEsquema.id());
        }else{
            throw new RuntimeException("Repositorio Titulo no esta en proceso");
        }
    }
    
    public List<ViewProcesoCiclo> getProcesos() {
        return viewProcesoCicloRepository.getProcesos();
    }

    public Optional<ViewProcesoCiclo> getProcesoById(Long procesoId, Long empresaId) {
        return viewProcesoCicloRepository.getProcesoById(procesoId, empresaId);
    }
    
    public List<ViewProcesoCicloRepositio> getRepositorios(Long procesoCicloId){
        return viewProcesoCicloRepositorioRepository.getRepositorions(procesoCicloId);
    }
}
