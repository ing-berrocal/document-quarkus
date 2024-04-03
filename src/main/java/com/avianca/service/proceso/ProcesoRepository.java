package com.avianca.service.proceso;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Proceso;

public interface ProcesoRepository {
    
    List<Proceso> getProcesos();

    Proceso crearProceso(Proceso procesoParam);

    Optional<Proceso> getProcesoById(Long empresaId,Long id);

    List<Proceso> getProcesos(Long empresaId,Long[] procesos);
    
    void modificarProceso(Long id,String titulo);
}
