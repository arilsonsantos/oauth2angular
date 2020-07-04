package br.com.orion.oauth2angular.infra.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApplication {
    
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}