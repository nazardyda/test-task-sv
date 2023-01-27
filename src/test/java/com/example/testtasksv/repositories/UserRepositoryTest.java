package com.example.testtasksv.repositories;

import com.example.testtasksv.entities.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserById() {
        UserEntity userEntity = new UserEntity(
                            "Tom",
                          "Holland",
                LocalDate.of(1995,
                            6,
                        15)
        );
        entityManager.persist(userEntity);

        UserEntity userEntity1 = new UserEntity(
                           "Tom",
                         "Brown",
                LocalDate.of(1987,
                            10,
                        2)
        );
        entityManager.persist(userEntity1);

        UserEntity findUserEntity = userRepository.
                findById(userEntity.
                        getId()).
                        get();

        assertThat(findUserEntity).isEqualTo(userEntity1);
    }
    @Test
    public void whenNoUsersInRepository() {
        Iterable<UserEntity> users = userRepository.findAll();
        assertThat(users).isEmpty();
    }

}
