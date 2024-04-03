/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.avianca.service.repositorio;

import com.avianca.model.RepositorioData;
import com.avianca.model.RepositorioEsquema;
import com.avianca.model.RepositorioTitulo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
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
public class RepositorioServicioTest {
    
    public RepositorioServicioTest() {
    }
    
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
     * Test of agregarEsquema method, of class RepositorioServicio.
     */
    @Test
    public void agregarEsquemaNoExisteTitulo() {
        
        RepositorioTituloRepositorio repositorioTituloRepositorioMock = Mockito.mock(RepositorioTituloRepositorio.class);
        RepositorioEsquemaRepository repositorioEsquemaRepositoryMock = Mockito.mock(RepositorioEsquemaRepository.class);
        RepositorioDataRepository repositorioDataRepositoryMock = Mockito.mock(RepositorioDataRepository.class);
        
        RepositorioServicio repositorioservicio = new RepositorioServicio(
                repositorioTituloRepositorioMock,
                repositorioEsquemaRepositoryMock,
                repositorioDataRepositoryMock,null
        );
        
        Mockito.when(repositorioTituloRepositorioMock.obtenerById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());
        
        RepositorioEsquema esquema = new RepositorioEsquema(null,null,"001", "pdf", LocalDate.MIN);
        
        RuntimeException assertThrows = assertThrows(RuntimeException.class, ()->{
            repositorioservicio.agregarEsquema(Long.valueOf("0"), esquema);
        });
        
        Mockito.verifyNoInteractions(repositorioEsquemaRepositoryMock);
        
        assertEquals(assertThrows.getMessage(), "No existe titulo para empresa");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void agregarEsquemaSinFechaVencimiento() {
        
        String codigo = "A0001";
        
        RepositorioTituloRepositorio repositorioTituloRepositorioMock = Mockito.mock(RepositorioTituloRepositorio.class);
        RepositorioEsquemaRepository repositorioEsquemaRepositoryMock = Mockito.mock(RepositorioEsquemaRepository.class);
        RepositorioDataRepository repositorioDataRepositoryMock = Mockito.mock(RepositorioDataRepository.class);
        
        RepositorioServicio repositorioservicio = new RepositorioServicio(
                repositorioTituloRepositorioMock,
                repositorioEsquemaRepositoryMock,
                repositorioDataRepositoryMock,null
        );
        
        Mockito.when(repositorioTituloRepositorioMock.obtenerById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.eq(codigo)))
                .thenReturn(Optional.of(new RepositorioTitulo(0L,codigo, "Cedula", null, Boolean.FALSE, LocalDateTime.MIN,null)));
        
        Mockito.doAnswer(answer->{
            return new RepositorioEsquema(Long.valueOf("1"),null,null,null,null);
        }).when(repositorioEsquemaRepositoryMock)
                .agregar(ArgumentMatchers.anyLong(), ArgumentMatchers.any(RepositorioEsquema.class));
        
        RepositorioEsquema esquema = new RepositorioEsquema(null,null,codigo, "pdf", LocalDate.MIN);
        
        RepositorioEsquema esquemaAgregado = repositorioservicio.agregarEsquema(Long.valueOf("0"), esquema);
        
        assertEquals(esquemaAgregado.id(), Long.valueOf("1"));
    }
    
    @Test
    public void agregarEsquemaConFechaVencimiento() {
        
        String codigo = "A0001";
        
        RepositorioTituloRepositorio repositorioTituloRepositorioMock = Mockito.mock(RepositorioTituloRepositorio.class);
        RepositorioEsquemaRepository repositorioEsquemaRepositoryMock = Mockito.mock(RepositorioEsquemaRepository.class);
        RepositorioDataRepository repositorioDataRepositoryMock = Mockito.mock(RepositorioDataRepository.class);
        
        RepositorioServicio repositorioservicio = new RepositorioServicio(
                repositorioTituloRepositorioMock,
                repositorioEsquemaRepositoryMock,
                repositorioDataRepositoryMock,null
        );
        
        Mockito.when(repositorioTituloRepositorioMock.obtenerById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.eq(codigo)))
                .thenReturn(Optional.of(new RepositorioTitulo(0L,codigo, "Cedula", null, Boolean.TRUE, LocalDateTime.MIN,null)));
        
        LocalDate now = LocalDate.now();

        LocalDate afterNow = now.plusMonths(5);
        
        Mockito.doAnswer(answer->{
            return new RepositorioEsquema(Long.valueOf("1"),null,null,null,
            afterNow);
        }).when(repositorioEsquemaRepositoryMock)
                .agregar(ArgumentMatchers.anyLong(), ArgumentMatchers.any(RepositorioEsquema.class));
        
        RepositorioEsquema esquema = new RepositorioEsquema(null,null,codigo, "pdf", LocalDate.MAX);
        
        RepositorioEsquema esquemaAgregado = repositorioservicio.agregarEsquema(Long.valueOf("0"), esquema);
        
        assertEquals(esquemaAgregado.id(), Long.valueOf("1"));
    }
    
    @Test
    public void agregarEsquemaConFechaVencimientoError() {
        
        String codigo = "A0001";
        
        RepositorioTituloRepositorio repositorioTituloRepositorioMock = Mockito.mock(RepositorioTituloRepositorio.class);
        RepositorioEsquemaRepository repositorioEsquemaRepositoryMock = Mockito.mock(RepositorioEsquemaRepository.class);
        RepositorioDataRepository repositorioDataRepositoryMock = Mockito.mock(RepositorioDataRepository.class);
        
        RepositorioServicio repositorioservicio = new RepositorioServicio(
                repositorioTituloRepositorioMock,
                repositorioEsquemaRepositoryMock,
                repositorioDataRepositoryMock,null
        );
        
        Mockito.when(repositorioTituloRepositorioMock.obtenerById(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(),ArgumentMatchers.eq(codigo)))
                .thenReturn(Optional.of(new RepositorioTitulo(0L,codigo, "Cedula", null, Boolean.TRUE, LocalDateTime.MIN,null)));
        
        LocalDate now = LocalDate.now();

        Mockito.doAnswer(answer->{
            return new RepositorioEsquema(Long.valueOf("1"),null,null,null,
            null);
        }).when(repositorioEsquemaRepositoryMock)
                .agregar(ArgumentMatchers.anyLong(), ArgumentMatchers.any(RepositorioEsquema.class));
        
        RepositorioEsquema esquema = new RepositorioEsquema(null,null,codigo, "pdf", now);
        
        RuntimeException assertThrows = assertThrows(RuntimeException.class, ()->{
            repositorioservicio.agregarEsquema(Long.valueOf("0"), esquema);
        });
        
        Mockito.verifyNoInteractions(repositorioEsquemaRepositoryMock);
        
        assertEquals(assertThrows.getMessage(), "Error en fecha");
    }
    
    @Test
    public void agregarData() {
        
        Long codigo = 1L;
        
        RepositorioTituloRepositorio repositorioTituloRepositorioMock = Mockito.mock(RepositorioTituloRepositorio.class);
        RepositorioEsquemaRepository repositorioEsquemaRepositoryMock = Mockito.mock(RepositorioEsquemaRepository.class);
        RepositorioDataRepository repositorioDataRepositoryMock = Mockito.mock(RepositorioDataRepository.class);
        
        RepositorioServicio repositorioservicio = new RepositorioServicio(
                repositorioTituloRepositorioMock,
                repositorioEsquemaRepositoryMock,
                repositorioDataRepositoryMock,null
        );
        
        Mockito.when(repositorioEsquemaRepositoryMock.getById(ArgumentMatchers.anyLong(),ArgumentMatchers.eq(codigo)))
                .thenReturn(Optional.of(new RepositorioEsquema(codigo,null,null,null,null)));
        
        
        Mockito.doAnswer(answer->{
            return new RepositorioData("pdf","abc".getBytes());
        }).when(repositorioDataRepositoryMock)
                .agregar(ArgumentMatchers.anyLong(), ArgumentMatchers.any(RepositorioData.class));
        
        RepositorioData repositorioData = new RepositorioData("pdf",null);
        
        repositorioservicio.agregarData(Long.valueOf("0"),codigo, repositorioData);
        
        assertNotNull(repositorioData.formato());
    }
}
