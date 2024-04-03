package com.avianca.service.repositorio;

import com.avianca.model.Proceso;
import com.avianca.model.RepositorioTitulo;
import com.avianca.service.proceso.ProcesoRepository;
import com.avianca.service.procesotitulo.ProcesoTituloRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RepositorioTituloServicio {
    
    private final RepositorioTituloRepositorio repositorioTituloRepositorio;
    private final ProcesoRepository procesoRepositorio;
    private final ProcesoTituloRepositorio procesoTituloRepositorio;
    
    public RepositorioTituloServicio(
            RepositorioTituloRepositorio repositorioTituloRepositorio,
            ProcesoRepository procesoRepositorio,
            ProcesoTituloRepositorio procesoTituloRepositorio) {
        this.repositorioTituloRepositorio = repositorioTituloRepositorio;
        this.procesoRepositorio = procesoRepositorio;
        this.procesoTituloRepositorio = procesoTituloRepositorio;
    }
    
    public List<RepositorioTitulo> getTitulo(Long empresaId){
        return this.repositorioTituloRepositorio.getTitulos(empresaId);
    }

    @Transactional
    public RepositorioTitulo agregar(Long empresaId, RepositorioTitulo repositorio, Long[] procesosId){
        
        if(repositorioTituloRepositorio.obtenerById(empresaId, null,repositorio.codigo()).isEmpty()){
            
            List<Proceso> procesos = procesoRepositorio.getProcesos(empresaId, procesosId);
            
            if(procesos.size() != procesos.size()){
                
            }
            
            RepositorioTitulo agregado = repositorioTituloRepositorio.agregar(empresaId, repositorio);
            
            procesoTituloRepositorio.registraTituloAProceso(agregado.id(), procesosId);
            
            return agregado;
        }
        throw new RuntimeException("Codigo se encuentra registrado");
    }
}
