package com.example.testtasksv.e2e;

import com.example.testtasksv.dtos.UserDTO;
import com.example.testtasksv.entities.UserEntity;
import com.example.testtasksv.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndToEndTest {
    @LocalServerPort
    private int port;
    private String defaultUrl = "http://localhost:";
    private static RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp() {
        defaultUrl = defaultUrl.concat(port + "");
    }
    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }
    @Test
    void testGetUserByUserIdSuccess() {
        UserEntity userEntity = new UserEntity(
                                         "Tom",
                                       "Holland",
                              LocalDate.of(1995,
                                          6,
                                      15)
        );
        userRepository.save(userEntity);

        UserEntity userRepo = userRepository.
                findById(userEntity.
                        getId()).
                         get();

        HttpEntity<UserEntity> userHttpEntity = new HttpEntity<>(userRepo);

        ResponseEntity<UserDTO> responseEntity = restTemplate.
                exchange(defaultUrl + "/users/" + userRepo.getId(),
                        HttpMethod.GET,
                        userHttpEntity,
                        UserDTO.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        userRepository.delete(userEntity);
    }
}
