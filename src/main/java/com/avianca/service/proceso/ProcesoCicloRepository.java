package com.avianca.service.proceso;

import com.avianca.model.ProcesoCiclo;
import java.util.Optional;

public interface ProcesoCicloRepository {    

    public Optional<ProcesoCiclo> getProcesoCicloById(Long empresaId,Long id);
    
    public ProcesoCiclo crearCiclo(ProcesoCiclo procesoCreacion);
    
    public void agregarRepositorio(ProcesoCiclo procesoCiclo, Long repositorioId);
    
}
