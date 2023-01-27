package com.example.testtasksv.services;


import com.example.testtasksv.dtos.UserDTO;
import com.example.testtasksv.entities.UserEntity;
import com.example.testtasksv.exceptions.NotFoundException;
import com.example.testtasksv.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

/**
 * @author nazardyda
 * @UserService service.
 */

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public UserDTO getById(UUID id) {
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException(NotFoundException.ID_NOT_FOUND);
        }
        UserEntity user = userRepository.findById(id).orElseGet(() -> UserEntity
                .builder()
                .id(id)
                .build()
        );
        return new UserDTO(user.getId(),
                user.getName(),
                user.getSurname(),
                Period.between(user.getBirthDate(),
                LocalDate.now()).getYears());
    }

}
