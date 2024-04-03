package com.avianca;

import java.util.Properties;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.avianca.service.tercero.TerceroService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    private TerceroService terceroService;
    
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
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/config")
    public String testConfig() {


        StringBuilder builder = new StringBuilder();

        builder.append(greetingConfig.name().orElse("configProperty")).append("\n");
        builder.append(greetingConfig.suffix()).append("\n");

        builder.append(greetingConfig.message()).append("\n");
        return builder.toString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
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
