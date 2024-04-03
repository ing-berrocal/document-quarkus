package com.avianca.persistencia.repository;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Empresa;
import com.avianca.service.empresa.EmpresaRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmpresaRepositoryImp implements EmpresaRepository{

    @Override
    public List<Empresa> getEmpresas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmpresas'");
    }

    @Override
    public void crear(Empresa itemParam) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public boolean existe(String documento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existe'");
    }

    @Override
    public Optional<Empresa> getEmpresaById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmpresaById'");
    }

    @Override
    public void modificarEmpresa(Long id, Empresa itemParam) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarEmpresa'");
    }
    
}
