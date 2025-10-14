package com.userservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginUserResponseDTO {
    private String userId  ;

    private String firstName;

    private String lastName;

    private String email;

    private String jwtToken ;
}
