package com.example.testtasksv.services;

import com.example.testtasksv.dtos.UserDTO;
import com.example.testtasksv.entities.UserEntity;
import com.example.testtasksv.exceptions.NotFoundException;
import com.example.testtasksv.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void whenGetUserByIdReturnUserDto() {

        UserEntity userEntity = UserEntity
                .builder()
                .id(UUID.fromString("877a4564-e53q-5787-7e46-44556e6000"))
                .birthDate(LocalDate.of(
                        2004, 1,3)
                )
                .name("Dean")
                .surname("McQuite")
                .build();

        given(userRepository.
                findById(userEntity.getId())).
                willReturn(Optional.of(userEntity));

        UserDTO userDTO = userService.
                          getById(userEntity.getId());

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getAge()).isEqualTo(19);
    }
    @Test
    void givenNotExistingUserId_whenGetUserById_thenThrowsException() {
        assertThrows(NotFoundException.class, () -> userService.
                                                    getById(UUID.randomUUID()));
    }
}
