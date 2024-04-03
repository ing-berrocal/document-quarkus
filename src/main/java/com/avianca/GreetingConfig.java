package com.avianca;

import java.util.Optional;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "greeting")
public interface GreetingConfig {

    String message();

    @WithDefault("!")
    String suffix();

    Optional<String> name();
} 
