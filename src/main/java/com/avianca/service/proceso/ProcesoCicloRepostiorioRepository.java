package com.avianca.service.proceso;

import com.avianca.model.ProcesoCiclo;
import com.avianca.model.ProcesoTitulo;
import java.util.List;

public interface ProcesoCicloRepostiorioRepository {    
    
    public void agregarProcesoCicloRepositorioTitulo(ProcesoCiclo procesoCiclo, List<ProcesoTitulo> repositorioTitulos);
    
    public int relacionarCicloRepoTituloData(Long procesoCicloId, Long repositorioTituloId, Long repositorioId);
}
