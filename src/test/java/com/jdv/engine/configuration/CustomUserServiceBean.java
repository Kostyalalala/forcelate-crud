package com.jdv.engine.configuration;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdv.engine.service.CustomUserService;


@Configuration
public class CustomUserServiceBean {
    @Bean
    public CustomUserService customUserService() {
        return mock(CustomUserService.class);
    }
}
