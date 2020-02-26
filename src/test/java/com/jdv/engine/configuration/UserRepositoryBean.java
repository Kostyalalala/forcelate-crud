package com.jdv.engine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdv.engine.db.repository.UserRepository;
import static org.mockito.Mockito.*;

@Configuration
public class UserRepositoryBean {
    @Bean
    public UserRepository jediDao() {
        return mock(UserRepository.class);
    }
}
