package com.avianca.service.procesorepositorioplantilla;

import java.util.List;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.model.ProcesoTitulo;

public interface ProcesoRepositorioPlantillaRepository {
    
    List<ProcesoPlantilla> getProcesos(Long repositorioTituloId);
    
    List<ProcesoTitulo> getRepositorioTitulos(Long empresaId,Long proceso);
    
    Boolean existeTituloEnRepostorio(Long proceso, Long repositorioTituloId);

    void registraPlantillaProceso(Long repositorioTituloId, Long[] procesos);
    
    void modificarProceso(Long repositorioTituloId, Long[] procesos);
}
