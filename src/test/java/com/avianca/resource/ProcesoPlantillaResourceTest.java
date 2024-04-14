/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.avianca.resource;

import com.avianca.model.ProcesoPlantilla;
import com.avianca.resource.response.ResponseCollection;
import com.avianca.resource.response.ResponseObject;
import com.avianca.service.proceso.ProcesoPlantillaRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
 * @author DELL
 */
@QuarkusTest
@TestHTTPEndpoint(ProcesoPlantillaResource.class)
public class ProcesoPlantillaResourceTest {
    
    @InjectMock
    private ProcesoPlantillaRepository ProcesoPlantillaRepositoryMock;
    
    public ProcesoPlantillaResourceTest() {
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

    /*@Test
    public void testHelloEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }*/
    
    /**
     * Test of getListado method, of class ProcesoPlantillaResource.
     */
    @Test
    public void getListado() {
        
        ProcesoPlantilla procesoPlantilla = new ProcesoPlantilla(1L, "XXX", "Proceso Test", Boolean.TRUE);
        
        Mockito.when(ProcesoPlantillaRepositoryMock.getProcesos()).thenReturn(Arrays.asList(procesoPlantilla));
        
        given()
          .when().get()
          .then()
             .statusCode(200)
             .body("data.id", CoreMatchers.hasItem(1));
    }
    
    /**
     * Test of getProcesoById method, of class ProcesoPlantillaResource.
     */
    
    public void getProcesoById() {
        
        ProcesoPlantilla procesoPlantilla = new ProcesoPlantilla(1L, "XXX", "Proceso Test", Boolean.TRUE);
        
        Mockito.when(ProcesoPlantillaRepositoryMock.getProcesoById(ArgumentMatchers.anyLong(), 
                ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
        
        given()
          .when().get("/{id}",1)
          .then()
             .statusCode(404)
             //.body("data.id", CoreMatchers.hasItem(1))
                ;
    }
}
