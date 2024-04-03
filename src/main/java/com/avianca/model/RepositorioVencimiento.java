package com.avianca.model;

import java.time.LocalDate;
public class RepositorioVencimiento extends Repositorio {
    
    private LocalDate fechaVencimiento;

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
}
