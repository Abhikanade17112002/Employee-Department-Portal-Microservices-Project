package com.departmentservice.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentResponseDTO {

    private String departmentName;

    private String description;

    private String departmentId ;
}
