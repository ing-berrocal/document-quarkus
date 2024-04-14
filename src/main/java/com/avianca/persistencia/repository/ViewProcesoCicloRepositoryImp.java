/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.view.ViewProcesoCiclo;
import com.avianca.persistencia.jpa.view.procesociclo.ViewProcesoCicloPanache;
import com.avianca.service.proceso.ViewProcesoCicloRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author DELL
 */
@ApplicationScoped
public class ViewProcesoCicloRepositoryImp implements ViewProcesoCicloRepository{

    @Inject
    private ViewProcesoCicloPanache viewProcesoCicloPanache;
    
    @Override
    public List<ViewProcesoCiclo> getProcesos() {
        return viewProcesoCicloPanache.streamAll()
                .map(vp->new ViewProcesoCiclo(vp.getId(), vp.getPlantillaId(), vp.getPantillaTitulo(), vp.getCicloTitulo(), vp.getFechaCreacion(), vp.getFechaValidoHasta()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ViewProcesoCiclo> getProcesoById(Long id, Long empresaId) {
        return viewProcesoCicloPanache.findByIdOptional(id)
                .map(vp->new ViewProcesoCiclo(vp.getId(), vp.getPlantillaId(), vp.getPantillaTitulo(), vp.getCicloTitulo(), vp.getFechaCreacion(), vp.getFechaValidoHasta()));
    }
    
}
