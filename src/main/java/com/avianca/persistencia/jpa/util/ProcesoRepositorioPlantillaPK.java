/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avianca.persistencia.jpa.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author Lenovo
 */
@Embeddable
public class ProcesoRepositorioPlantillaPK {
    
    public ProcesoRepositorioPlantillaPK(){}
    
     public ProcesoRepositorioPlantillaPK(Long repositorioTituloId, Long procesoId) {
            this.repositorioTituloId = repositorioTituloId;
            this.procesoId = procesoId;
        }
        
        @Column(name = "REPOSITORIO_PLANTILLA_ID",nullable = false)
        //@ManyToOne
        //@JoinColumn(name = "REPOSITORIO_TITULO_ID")
        private Long repositorioTituloId;
        @Column(name = "PROCESO_PLANTILLA_ID",nullable = false)
        //@ManyToOne
        //@JoinColumn(name = "PROCESO_ID")
        private Long procesoId;

        public Long getRepositorioTituloId() {
            return repositorioTituloId;
        }

        public void setRepositorioTituloId(Long repositorioTituloId) {
            this.repositorioTituloId = repositorioTituloId;
        }

        public Long getProcesoId() {
            return procesoId;
        }

        public void setProcesoId(Long procesoId) {
            this.procesoId = procesoId;
        }
}
