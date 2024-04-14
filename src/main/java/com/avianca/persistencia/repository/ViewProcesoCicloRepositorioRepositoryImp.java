/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.repository;

import com.avianca.model.view.ViewProcesoCicloRepositio;
import com.avianca.service.proceso.ViewProcesoCicloRepositorioRepository;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
@ApplicationScoped
public class ViewProcesoCicloRepositorioRepositoryImp implements ViewProcesoCicloRepositorioRepository{

    public final AgroalDataSource datasource;

    private final String SQL = """
                               SELECT id, repositorio_plantilla_id, codigo, titulo, tiene_fecha_vencimiento, repositorio_ciclo_id, formato, fecha_vencimiento
                               FROM public.view_proceso_ciclo_repositorio_ciclo
                               WHERE proceso_ciclo_id = ?;
                               """;
    
    public ViewProcesoCicloRepositorioRepositoryImp(AgroalDataSource datasource) {
        this.datasource = datasource;
    }        
     
    @Override
    public List<ViewProcesoCicloRepositio> getRepositorions(Long procesoCicloId) {
        
        ResultSet result;
        List<ViewProcesoCicloRepositio> resultado = new ArrayList<>();
        try(Connection conection = datasource.getConnection();
                PreparedStatement statment = conection.prepareStatement(SQL)){            
            statment.setLong(1, procesoCicloId);
            
            result = statment.executeQuery();
            
            while(result.next()){
                resultado.add(
                ViewProcesoCicloRepositio.getInstance(
                        result.getLong(1),
                        result.getLong(2),
                        result.getString(3),
                        result.getString(4),
                        result.getBoolean(5),
                        result.getLong(6),
                        result.getString(7),
                        (result.getTimestamp(8) == null ? null : result.getTimestamp(8).toLocalDateTime().toLocalDate())
                )
                );
            }
        }
        catch(SQLException e){
            System.err.println("Error");
        }
        return resultado;
    }
    
    
    
}
