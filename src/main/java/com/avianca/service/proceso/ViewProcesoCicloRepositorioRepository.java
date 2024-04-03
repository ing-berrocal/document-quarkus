/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.service.proceso;

import com.avianca.model.view.ViewProcesoCicloRepositio;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ViewProcesoCicloRepositorioRepository {
    List<ViewProcesoCicloRepositio> getRepositorions(Long procesoCicloId);
}
