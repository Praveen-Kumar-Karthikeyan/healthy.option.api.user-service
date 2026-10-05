package com.healthy.option.api.user_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean(name = "objectMapperForUserService")
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
