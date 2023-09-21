package com.victorsaccucci.Sistemaorquidarioprojeto.apiconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrefleConfig {

    @Value("${trefle.api.key}")
    private String apiKey;

    @Bean
    public String trefleApiKey() {
        return apiKey;
    }
}
