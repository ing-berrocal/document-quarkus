package com.avianca.service.empresa;

import java.util.List;
import java.util.Optional;

import com.avianca.model.Empresa;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository;

    public EmpresaService(
        EmpresaRepository empresaRepository
    ){
        this.empresaRepository = empresaRepository;
    }

    @PostConstruct 
    void init() {
        /*terceroList.add(new Tercero("1001", 
        "Berrocal Anaya", 
        "Daniel Antonio", 
        TipoDocumento.CC, 
        "1067874099", null));*/
    }

    @PreDestroy 
    void destroy() {
      // ...
    }

    public List<Empresa> getEmpresas(){
        return empresaRepository.getEmpresas();
    }

    @Transactional
    public Empresa crearTercero(Empresa itemParam){
        if(!existeItem(itemParam.nit())){
            empresaRepository.crear(itemParam);
        }else{
            throw new RuntimeException("Tercero registrado en el sistema");
        }
        return itemParam;
    }

    private boolean existeItem(String documento) {
        return empresaRepository.existe(documento);
    }

    @Transactional
    public Empresa modificar(Long id,Empresa itemParam) {

        Optional<Empresa> itemById = empresaRepository.getEmpresaById(id);

        if(!itemById.isPresent()){
            throw new RuntimeException("Tercero no registrado en el sistema");
        }

        itemById.ifPresent(t -> {
            empresaRepository.modificarEmpresa(id, itemParam);
        });

        return itemParam;
    }

    
}
