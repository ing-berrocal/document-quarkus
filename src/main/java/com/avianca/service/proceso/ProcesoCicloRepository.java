package com.avianca.service.proceso;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoCiclo;
import java.util.Optional;

public interface ProcesoCicloRepository {    

    public Optional<ProcesoCiclo> getProcesoCicloById(Long empresaId,Long id);
    
    public ProcesoCiclo crearCiclo(Proceso proceso);
    
    public void agregarRepositorio(ProcesoCiclo procesoCiclo, Long repositorioId);
    
}
