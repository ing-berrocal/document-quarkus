/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.avianca.service.proceso;

import com.avianca.model.Proceso;
import com.avianca.model.ProcesoCiclo;
import com.avianca.model.RepositorioEsquema;
import com.avianca.service.procesotitulo.ProcesoTituloRepositorio;
import com.avianca.service.repositorio.RepositorioEsquemaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

/**
 *
 * @author Lenovo
 */
public class ProcesoCicloServicioTest {
    
    
    ProcesoCicloRepository procesoCicloRepository = Mockito.mock(ProcesoCicloRepository.class);
    ProcesoTituloRepositorio procesoTituloRepositorio = Mockito.mock(ProcesoTituloRepositorio.class);
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregar method, of class ProcesoCicloServicio.
     */
    @Test
    public void noExisteProceso() {
        
        ProcesoRepository repository = Mockito.mock(ProcesoRepository.class);
        
        Long empresaId = 1L;
        Long procesoId = 1L;
        Long terceroId = null;
        
        Mockito.when(repository.getProcesoById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        
        ProcesoCicloServicio instance = new ProcesoCicloServicio(
                repository, 
                procesoCicloRepository, 
                procesoTituloRepositorio, null,null,null,null);

        RuntimeException assertThrows = Assertions.assertThrows(RuntimeException.class, ()->{
            instance.agregar(empresaId, procesoId, terceroId);
        });
        
        Assertions.assertEquals("No existe proceso", assertThrows.getMessage());
    }
    
    @Test
    public void guardado() {
        
        ProcesoRepository repository = Mockito.mock(ProcesoRepository.class);
        
        Long empresaId = 1L;
        Long procesoId = 1L;
        Long terceroId = null;
        
        Mockito.when(repository.getProcesoById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(new Proceso(null,null,null)));
        
        ProcesoCicloServicio instance = new ProcesoCicloServicio(
                repository, 
                procesoCicloRepository, 
                procesoTituloRepositorio, null,null,null,null);

        
        instance.agregar(empresaId, procesoId, terceroId);
        
        
        //Assertions.assertEquals("No existe proceso", assertThrows.getMessage());
    }

    /**
     * Test of agregar method, of class ProcesoCicloServicio.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Long empresaId = null;
        Long procesoId = null;
        Long terceroId = null;
        ProcesoCicloServicio instance = null;
        instance.agregar(empresaId, procesoId, terceroId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRepositorio method, of class ProcesoCicloServicio.
     */
    @Test
    public void testAgregarRepositorio() {
        
        ProcesoCicloRepository procesoCicloRepository = Mockito.mock(ProcesoCicloRepository.class);
        ProcesoRepository repository = Mockito.mock(ProcesoRepository.class);
        RepositorioEsquemaRepository repositorioEsquemaRepository = Mockito.mock(RepositorioEsquemaRepository.class);
        
        Long empresaId = 1L;
        Long cicloId = 1L;
        Long procesoId = 1L;
        Long terceroId = null;
        
        Mockito.when(procesoCicloRepository.getProcesoCicloById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(new ProcesoCiclo(1L,1L,null,null,null)));
        
        /*Mockito.when(repository.getProcesoById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(new Proceso(1L,null,null)));*/
        
        Mockito.when(repositorioEsquemaRepository.getById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(new RepositorioEsquema(0L, 1L, null, null, LocalDate.MIN)));
        
        Mockito.when(procesoTituloRepositorio.existeTituloEnRepostorio(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong()))
                .thenReturn(Boolean.TRUE);
        
        ProcesoCicloServicio instance = new ProcesoCicloServicio(
                repository, 
                procesoCicloRepository, 
                procesoTituloRepositorio, 
                repositorioEsquemaRepository,null,null,null);

        
        instance.agregarRepositorio(empresaId, cicloId, 1L, null);
        
    }

    /**
     * Test of getProcesos method, of class ProcesoCicloServicio.
     */
    @Test
    public void testGetProcesos() {
        System.out.println("getProcesos");
        ProcesoCicloServicio instance = null;
        List<ProcesoCiclo> expResult = null;
        List result = instance.getProcesos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcesoById method, of class ProcesoCicloServicio.
     */
    @Test
    public void testGetProcesoById() {
        System.out.println("getProcesoById");
        long l = 0L;
        Long procesoId = null;
        ProcesoCicloServicio instance = null;
        ProcesoCiclo expResult = null;
        ProcesoCiclo result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
