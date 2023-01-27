package com.example.testtasksv.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.UUID;

/**
 * @author nazardyda
 * @UserDTO - DTO
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @JsonIgnore
    private UUID id;
    private String name;
    private String surname;
    private int age;
}
