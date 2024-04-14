package com.avianca.service.repositorio;

import com.avianca.model.RepositorioCiclo;
import com.avianca.model.RepositorioData;
import com.avianca.model.RepositorioPlantilla;
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
    private final RepositorioCicloRepository repositorioEsquemaRepository;
    private final RepositorioDataRepository repositorioDataRepository;
    private final ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository;

    public RepositorioServicio(RepositorioTituloRepositorio repositorioTituloRepository,
            RepositorioCicloRepository repositorioEsquemaRepository,
            RepositorioDataRepository repositorioDataRepository,
            ProcesoCicloRepostiorioRepository procesoCicloRepostiorioRepository) {
        this.repositorioTituloRepository = repositorioTituloRepository;
        this.repositorioEsquemaRepository = repositorioEsquemaRepository;
        this.repositorioDataRepository = repositorioDataRepository;
        this.procesoCicloRepostiorioRepository = procesoCicloRepostiorioRepository;
    }

    public List<RepositorioCiclo> getRepositorio(Long empresaId) {
        return repositorioEsquemaRepository.getRepositorio(empresaId);
    }

    @Transactional
    public RepositorioCiclo agregarEsquema(Long empresaId,
            RepositorioCiclo esquema) {

        Optional<RepositorioPlantilla> obtenerById = repositorioTituloRepository.obtenerById(empresaId, null,esquema.codigo());

        RepositorioPlantilla rt = obtenerById.orElseThrow(() -> {
            throw new RuntimeException("No existe titulo para empresa");
        });

        if (rt.tieneFechaVencimiento()) {
            if (!LocalDate.now().isBefore(esquema.fechaVencimiento())) {
                throw new RuntimeException("Error en fecha");
            }
        }
        return repositorioEsquemaRepository.agregar(empresaId, esquema);
    }

    public Optional<RepositorioCiclo> getEsquemaById(Long empresaId, Long Id) {
        return repositorioEsquemaRepository.getById(empresaId, Id);
    }
    
    public Optional<RepositorioData> getDataById(Long repositorioId) {
        return repositorioDataRepository.getById(repositorioId);
    }
    
    @Transactional
    public RepositorioData agregarData(Long empresaId,
            Long repositorioId,
            RepositorioData data) {

        Optional<RepositorioCiclo> byId = repositorioEsquemaRepository.getById(empresaId,repositorioId);

        RepositorioCiclo orElseThrow = byId.orElseThrow(() -> {
            throw new RuntimeException("No existe esquema para la empresa");
        });
        
        return repositorioDataRepository.agregar(orElseThrow.id(), 
                new RepositorioData(orElseThrow.formato(), data.data()));
    }
    
    @Transactional
    public RepositorioCiclo agregarRepositorio(
            Long empresaId,
            Long cicloId,
            Long repositorioTituloId,
            
            RepositorioCiclo esquema,
            RepositorioData data) {

        Optional<RepositorioPlantilla> obtenerById = repositorioTituloRepository.obtenerById(empresaId, repositorioTituloId, esquema.codigo());

        RepositorioPlantilla rt = obtenerById.orElseThrow(() -> {
            throw new RuntimeException("No existe titulo para empresa");
        });

        if (rt.tieneFechaVencimiento()) {
            if (Objects.isNull(esquema.fechaVencimiento()) || LocalDate.now().isAfter(esquema.fechaVencimiento())) {
                throw new RuntimeException("Error en fecha");
            }
        }
        
        RepositorioCiclo esquemaTmp = new RepositorioCiclo(null, repositorioTituloId, rt.codigo(),"pdf",esquema.fechaVencimiento());
        
        RepositorioCiclo esquemaAgregado = repositorioEsquemaRepository.agregar(empresaId, esquemaTmp);
        
        repositorioDataRepository.agregar(esquemaAgregado.id(), new RepositorioData(esquemaTmp.formato(), data.data()));
        
        int relacionarCicloRepoTituloData = procesoCicloRepostiorioRepository.relacionarCicloRepoTituloData(cicloId, repositorioTituloId, esquemaAgregado.id());
        
        return esquemaAgregado;
    }
    
    private LocalDate validarFechaVencimiento(Optional<LocalDate> fechaVencimeintoOptional){
        return fechaVencimeintoOptional.filter(fvo->LocalDate.now().isBefore(fvo)).orElseThrow();
    }        
}
