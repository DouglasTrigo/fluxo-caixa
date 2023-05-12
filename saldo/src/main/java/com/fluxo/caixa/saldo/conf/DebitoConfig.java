package com.fluxo.caixa.saldo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DebitoConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}