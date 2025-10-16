package com.userservice.entities;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {
    private String departmentId;

    private String departmentName;

    private String description;
}
