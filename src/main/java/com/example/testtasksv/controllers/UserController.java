package com.example.testtasksv.controllers;

import com.example.testtasksv.dtos.UserDTO;
import com.example.testtasksv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author nazardyda
 * @UserController - Controller
 */

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO getUserAgeById(@PathVariable("userId") UUID id){
        return userService.getById(id);
    }
}
