package com.departmentservice.dtos;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDTO {
    @NotNull( message = "Department Name Cannot Be Null")
    private String departmentName;

    @NotNull( message = "Department Description Cannot Be Null")
    private String description;
}
