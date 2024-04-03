package com.avianca.resource.request;

import jakarta.ws.rs.FormParam;
import java.io.File;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public class RepositorioFormRequest {
    
    @FormParam("codigo")
    private String codigo;
    @FormParam("fecha_vencimiento")
    private String fechaVencimiento;

    @FormParam("archivo")
    File inpit;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setInpit(File inpit) {
        this.inpit = inpit;
    }

    public File getInpit() {
        return inpit;
    }
    
    
}
