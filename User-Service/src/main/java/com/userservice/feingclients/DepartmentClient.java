package com.userservice.feingclients;

import com.userservice.entities.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("/api/departments/{id}")
    Department getDepartmentById(@PathVariable("id") String departmentId);
}
