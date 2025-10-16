package com.userservice.feingclients;

import com.userservice.entities.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8082")
public interface DepartmentClient {

    @GetMapping("/api/departments/{id}")
    Department getDepartmentById(@PathVariable("id") String departmentId);
}
