package com.example.testtasksv.e2e;

import com.example.testtasksv.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryTest extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findById(UUID uuid);
}
