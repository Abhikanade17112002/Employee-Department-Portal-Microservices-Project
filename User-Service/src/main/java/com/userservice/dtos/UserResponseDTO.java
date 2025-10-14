package com.userservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserResponseDTO {
    private String userId  ;

    private String firstName;

    private String lastName;

    private String email;

}
