/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.service.proceso;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoCiclo;
import com.avianca.model.ProcesoTitulo;
import com.avianca.model.RepositorioEsquema;
import com.avianca.model.view.ViewProcesoCicloRepositio;
import com.avianca.model.view.ViewProcesoCiclo;
import com.avianca.service.procesotitulo.ProcesoTituloRepositorio;
import com.avianca.service.repositorio.RepositorioEsquemaRepository;
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

    private final ProcesoRepository repository;
    private final ProcesoCicloRepository procesoCicloRepository;
    private final ProcesoTituloRepositorio procesoTituloRepositorio;
    private final RepositorioEsquemaRepository repositorioEsquemaRepository;
    private final ViewProcesoCicloRepository viewProcesoCicloRepository;
    private final ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository;
    private final ViewProcesoCicloRepositorioRepository viewProcesoCicloRepositorioRepository;
    
    public ProcesoCicloServicio(ProcesoRepository repository,
            ProcesoCicloRepository procesoCicloRepository,
            ProcesoTituloRepositorio procesoTituloRepositorio,
            RepositorioEsquemaRepository repositorioEsquemaRepository,
            ViewProcesoCicloRepository viewProcesoCicloRepository,
            ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository,
            ViewProcesoCicloRepositorioRepository viewProcesoCicloRepositorioRepository) {
        this.repository = repository;
        this.procesoCicloRepository = procesoCicloRepository;
        this.procesoTituloRepositorio = procesoTituloRepositorio;
        this.repositorioEsquemaRepository = repositorioEsquemaRepository;
        this.viewProcesoCicloRepository = viewProcesoCicloRepository;
        this.procesoCicloRepostiorioRepository = procesoCicloRepostiorioRepository;
        this.viewProcesoCicloRepositorioRepository = viewProcesoCicloRepositorioRepository;
    }
    
    @Transactional
    public ProcesoCiclo agregar(Long empresaId, Long procesoId, Long terceroId){
        
        Optional<Proceso> procesoById = repository.getProcesoById(empresaId, procesoId);
        
        if(procesoById.isEmpty()){
            throw new RuntimeException("No existe proceso");
        }
                
        List<ProcesoTitulo> repositorioTitulos = procesoTituloRepositorio.getRepositorioTitulos(empresaId, procesoId);
        
        if(repositorioTitulos.isEmpty()){
            throw new RuntimeException("No existe titulos para proceso");
        }
        
        Proceso proceso = procesoById.get();               
        
        ProcesoCiclo cicloCreado = procesoCicloRepository.crearCiclo(proceso);
        
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
        
        Optional<RepositorioEsquema> byId = repositorioEsquemaRepository.getById(empresaId, repositorioId);
        
        if(byId.isEmpty()){
            throw new RuntimeException("No existe repositorio");
        }
        
        RepositorioEsquema repositorioEsquema = byId.get();
        
        if(procesoTituloRepositorio.existeTituloEnRepostorio(procesoCiclo.procesoId(), repositorioEsquema.repositorioTituloId())){
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
