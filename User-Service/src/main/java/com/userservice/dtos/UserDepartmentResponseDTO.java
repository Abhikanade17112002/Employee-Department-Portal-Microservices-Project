package com.userservice.dtos;

import com.userservice.entities.Department;
import com.userservice.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDepartmentResponseDTO {

    private User user ;
    private Department department ;


}
