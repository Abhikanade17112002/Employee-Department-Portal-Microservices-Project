package com.userservice.dtos;

import jakarta.validation.constraints.Min;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateUserRequestDTO {

    private String firstName;

    private String lastName;

    private String email;
    private int age ;

    private String departmentId ;
}
