package com.avianca.tercero;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.avianca.model.Tercero;
import com.avianca.model.TipoDocumento;
import com.avianca.resource.TerceroResource;
import com.avianca.service.tercero.TerceroRepository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(TerceroResource.class)
public class TerceroResourceTest {
    
    /*
    @InjectMock
    TerceroRepository terceroRepository;
    */

    @Test
    public void testHelloEndpoint() {

        //Panache.mock(Order.class);
        /*
        Mockito.when(terceroRepository.getTerceros())
        .thenReturn(Arrays.asList(new Tercero(null, null, null, 
        TipoDocumento.CC, 
        null, 
        null),
        new Tercero(null, null, null, 
        TipoDocumento.CC, 
        null, 
        null)));
        */

        given().log()
        .everything()
          .when().get()
          .then()
             .statusCode(200)
             .body("tipoDocumento",hasItem("CC"));
    }
}
