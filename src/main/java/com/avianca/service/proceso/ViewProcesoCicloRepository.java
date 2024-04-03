package com.avianca.service.proceso;

import com.avianca.model.view.ViewProcesoCiclo;
import java.util.List;
import java.util.Optional;

public interface ViewProcesoCicloRepository {    
    public List<ViewProcesoCiclo> getProcesos();    
    public Optional<ViewProcesoCiclo> getProcesoById(Long id,Long empresaId);    
}
