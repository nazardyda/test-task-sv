package com.example.testtasksv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.testtasksv.repositories")
public class TestTaskSvApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskSvApplication.class, args);
    }

}
