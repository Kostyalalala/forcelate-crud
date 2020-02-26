package com.jdv.engine.db.repository;

import static com.jdv.engine.constants.Constants.AGE;
import static com.jdv.engine.constants.Constants.TOM_OLDER;
import static com.jdv.engine.constants.Constants.TOM_YOUNGER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jdv.engine.configuration.UserRepositoryBean;

@RunWith(SpringJUnit4ClassRunner.class)
@Import({ UserRepositoryBean.class })
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(true)
    public void getUsersByAge() {
        userRepository.save(Arrays.asList(TOM_OLDER, TOM_YOUNGER));

        assertThat(userRepository.getUsersWithOlderAge(AGE)).containsOnly(TOM_OLDER);
    }
}
