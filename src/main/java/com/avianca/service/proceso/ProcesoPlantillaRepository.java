package com.avianca.service.proceso;

import java.util.List;
import java.util.Optional;

import com.avianca.model.ProcesoPlantilla;

public interface ProcesoPlantillaRepository {
    
    List<ProcesoPlantilla> getProcesos();

    ProcesoPlantilla crearProceso(ProcesoPlantilla procesoParam);

    Optional<ProcesoPlantilla> getProcesoById(Long empresaId,Long id);

    List<ProcesoPlantilla> getProcesos(Long empresaId,Long[] procesos);
    
    void modificarProceso(Long id,String titulo);
}
