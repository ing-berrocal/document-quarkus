package com.avianca.service.repositorio;

import com.avianca.model.RepositorioData;
import com.avianca.model.RepositorioEsquema;
import com.avianca.model.RepositorioTitulo;
import com.avianca.service.proceso.ProcesoCicloRepostiorioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class RepositorioServicio {

    private final RepositorioTituloRepositorio repositorioTituloRepository;
    private final RepositorioEsquemaRepository repositorioEsquemaRepository;
    private final RepositorioDataRepository repositorioDataRepository;
    private final ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository;

    public RepositorioServicio(RepositorioTituloRepositorio repositorioTituloRepository,
            RepositorioEsquemaRepository repositorioEsquemaRepository,
            RepositorioDataRepository repositorioDataRepository,
            ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository) {
        this.repositorioTituloRepository = repositorioTituloRepository;
        this.repositorioEsquemaRepository = repositorioEsquemaRepository;
        this.repositorioDataRepository = repositorioDataRepository;
        this.procesoCicloRepostiorioRepository = procesoCicloRepostiorioRepository;
    }

    public List<RepositorioEsquema> getRepositorio(Long empresaId) {
        return repositorioEsquemaRepository.getRepositorio(empresaId);
    }

    @Transactional
    public RepositorioEsquema agregarEsquema(Long empresaId,
            RepositorioEsquema esquema) {

        Optional<RepositorioTitulo> obtenerById = repositorioTituloRepository.obtenerById(empresaId, null,esquema.codigo());

        RepositorioTitulo rt = obtenerById.orElseThrow(() -> {
            throw new RuntimeException("No existe titulo para empresa");
        });

        if (rt.tieneFechaVencimiento()) {
            if (!LocalDate.now().isBefore(esquema.fechaVencimiento())) {
                throw new RuntimeException("Error en fecha");
            }
        }
        return repositorioEsquemaRepository.agregar(empresaId, esquema);
    }

    public Optional<RepositorioEsquema> getEsquemaById(Long empresaId, Long Id) {
        return repositorioEsquemaRepository.getById(empresaId, Id);
    }
    
    public Optional<RepositorioData> getDataById(Long repositorioId) {
        return repositorioDataRepository.getById(repositorioId);
    }
    
    @Transactional
    public RepositorioData agregarData(Long empresaId,
            Long repositorioId,
            RepositorioData data) {

        Optional<RepositorioEsquema> byId = repositorioEsquemaRepository.getById(empresaId,repositorioId);

        RepositorioEsquema orElseThrow = byId.orElseThrow(() -> {
            throw new RuntimeException("No existe esquema para la empresa");
        });
        
        return repositorioDataRepository.agregar(orElseThrow.id(), 
                new RepositorioData(orElseThrow.formato(), data.data()));
    }
    
    @Transactional
    public RepositorioEsquema agregarRepositorio(
            Long empresaId,
            Long cicloId,
            Long repositorioTituloId,
            
            RepositorioEsquema esquema,
            RepositorioData data) {

        Optional<RepositorioTitulo> obtenerById = repositorioTituloRepository.obtenerById(empresaId, repositorioTituloId, esquema.codigo());

        RepositorioTitulo rt = obtenerById.orElseThrow(() -> {
            throw new RuntimeException("No existe titulo para empresa");
        });

        if (rt.tieneFechaVencimiento()) {
            if (Objects.isNull(esquema.fechaVencimiento()) || LocalDate.now().isAfter(esquema.fechaVencimiento())) {
                throw new RuntimeException("Error en fecha");
            }
        }
        
        RepositorioEsquema esquemaTmp = new RepositorioEsquema(null, repositorioTituloId, rt.codigo(),"pdf",esquema.fechaVencimiento());
        
        RepositorioEsquema esquemaAgregado = repositorioEsquemaRepository.agregar(empresaId, esquemaTmp);
        
        repositorioDataRepository.agregar(esquemaAgregado.id(), new RepositorioData(esquemaTmp.formato(), data.data()));
        
        int relacionarCicloRepoTituloData = procesoCicloRepostiorioRepository.relacionarCicloRepoTituloData(cicloId, repositorioTituloId, esquemaAgregado.id());
        
        return esquemaAgregado;
    }
    
    private LocalDate validarFechaVencimiento(Optional<LocalDate> fechaVencimeintoOptional){
        return fechaVencimeintoOptional.filter(fvo->LocalDate.now().isBefore(fvo)).orElseThrow();
    }        
}
