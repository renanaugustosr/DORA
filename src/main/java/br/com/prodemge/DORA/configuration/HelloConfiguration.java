package br.com.prodemge.DORA.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

    @Bean
    public String helloWorldMessage() {
        return "Hello, World!";
    }
    
}
