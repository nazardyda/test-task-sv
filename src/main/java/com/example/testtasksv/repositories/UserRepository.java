package com.example.testtasksv.repositories;

import com.example.testtasksv.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author nazardyda
 * @UserRepository - repository
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity,UUID> {
    Optional<UserEntity> findById(UUID uuid);
}
