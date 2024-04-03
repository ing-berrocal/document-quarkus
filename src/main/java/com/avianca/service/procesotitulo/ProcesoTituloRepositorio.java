package com.avianca.service.procesotitulo;

import java.util.List;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoTitulo;

public interface ProcesoTituloRepositorio {
    
    List<Proceso> getProcesos(Long repositorioTituloId);
    
    List<ProcesoTitulo> getRepositorioTitulos(Long empresaId,Long proceso);
    
    Boolean existeTituloEnRepostorio(Long proceso, Long repositorioTituloId);

    void registraTituloAProceso(Long repositorioTituloId, Long[] procesos);
    
    void modificarProceso(Long repositorioTituloId, Long[] procesos);
}
