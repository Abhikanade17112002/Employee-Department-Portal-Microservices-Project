package com.departmentservice.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateDepartmentRequestDTO {

    private String departmentName;


    private String description;
}
