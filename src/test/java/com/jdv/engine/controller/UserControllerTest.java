package com.jdv.engine.controller;

import static com.jdv.engine.constants.Constants.AGE;
import static com.jdv.engine.constants.Constants.AUTHORIZATION;
import static com.jdv.engine.constants.Constants.JWT_TOKEN;
import static com.jdv.engine.constants.Constants.TOM_OLDER_DTO;
import static com.jdv.engine.constants.Constants.TOM_YOUNGER_DTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdv.engine.configuration.CustomUserServiceBean;
import com.jdv.engine.dto.UserDTO;
import com.jdv.engine.service.CustomUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class UserControllerTest {


    @Configuration
    @Import({ CustomUserServiceBean.class })
    static class ContextConfiguration {

        @Autowired
        private CustomUserService customUserService;

        @Bean
        public UserController userController() {
            return new UserController(customUserService);
        }
    }

    @Autowired
    private CustomUserService customUserService;

    @Autowired
    private UserController resourceUnderTest;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getUsersByAge() throws Exception {
        List<UserDTO> users = Arrays.asList(TOM_OLDER_DTO);
        when(customUserService.getUsersByAge(AGE)).thenReturn(users);

        MockMvc mvc = MockMvcBuilders.standaloneSetup(resourceUnderTest).build();

        String result = mvc
            .perform(get("/api/user/age/" + AGE).contentType(MediaType.APPLICATION_JSON)
                .header(AUTHORIZATION, JWT_TOKEN))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<UserDTO> resultUsers = mapper.readValue(result, new TypeReference<List<UserDTO>>(){});
        
        assertThat(resultUsers).isEqualTo(users);
        verify(customUserService).getUsersByAge(AGE);
        assertThat(resourceUnderTest.getUsersByAge(AGE)).doesNotContain(TOM_YOUNGER_DTO);

    }
}
