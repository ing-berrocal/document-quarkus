package com.avianca.service.empresa;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Empresa;

public interface EmpresaRepository {

    List<Empresa> getEmpresas();

    void crear(Empresa itemParam);

    boolean existe(String documento);

    Optional<Empresa> getEmpresaById(Long id);

    void modificarEmpresa(Long id,Empresa itemParam);
}
