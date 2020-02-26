package com.jdv.engine.service;

import static com.jdv.engine.constants.Constants.AGE;
import static com.jdv.engine.constants.Constants.TOM_OLDER;
import static com.jdv.engine.dto.Transfromer.UserEntityToDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jdv.engine.configuration.UserRepositoryBean;
import com.jdv.engine.db.repository.UserRepository;
import com.jdv.engine.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class CustomUserServiceTest {
    @Configuration
    @Import({ UserRepositoryBean.class })
    static class ContextConfiguration {

        @Autowired
        private UserRepository userRepository;

        @Bean
        public CustomUserService customUserService() {
            return new CustomUserService(userRepository);
        }
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserService customUserService;

    @Before
    public void before() {
        reset(userRepository);
    }

    @After
    public void after() {
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void getUsersByAge() {
        when(userRepository.getUsersWithOlderAge(AGE)).thenReturn(Arrays.asList(TOM_OLDER));

        List<UserDTO> users = customUserService.getUsersByAge(AGE);

        assertThat(users).isNotEmpty();
        verify(userRepository).getUsersWithOlderAge(AGE);
        assertThat(users).containsOnly(UserEntityToDTO(TOM_OLDER));
    }
}
