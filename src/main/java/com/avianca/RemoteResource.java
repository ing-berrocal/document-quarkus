package com.avianca;

import java.util.Properties;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/remote")
public class RemoteResource {

    @ConfigProperty(name = "example.config.value.env")
    String configProperty;

    @ConfigProperty(name = "endpoint.url")
    String url;

    @ConfigProperty(name = "endpoint.port")
    String port;

    @ConfigProperty(name = "debug-flag", defaultValue = "false")
    boolean debugFlag;

    @Inject
    GreetingConfig greetingConfig;

    @Inject
    private Config config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String saludo() {
        return "Hola, desde el servicio";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/saludo")
    public String testConfig(@QueryParam("name") String name) {
        return String.format("Hola, %s",  name);   
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String environment() {

        Properties properties = System.getProperties();

        StringBuilder builder = new StringBuilder();

        builder.append(url).append("\n");
        builder.append(port).append("\n");
        builder.append(configProperty).append("\n");

        builder.append("---------------------------------------\n");

        properties.forEach((k,v)->{
            builder.append(String.format("%s : %s", k, v)).append("\n");
        });

        return builder.toString();
    }
}
