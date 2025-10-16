package com.departmentservice.controllers;

import com.departmentservice.dtos.DepartmentRequestDTO;
import com.departmentservice.dtos.DepartmentResponseDTO;
import com.departmentservice.dtos.UpdateDepartmentRequestDTO;
import com.departmentservice.entities.Department;
import com.departmentservice.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO department) {
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(
                departmentService.registerDepartment( department )
        ) ;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {
        return   ResponseEntity.status(HttpStatus.OK)
                .body(departmentService.getAllRegisteredDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable( name = "id") String departmentId) {
        return
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(departmentService.getRegisteredDepartmentById(departmentId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable( name = "id") String departmentId, @Valid @RequestBody UpdateDepartmentRequestDTO updatedDept) {
        return ResponseEntity.status(HttpStatus.OK)
                        .body(

                departmentService.updateRegisteredDepartment(departmentId, updatedDept) ) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable( name = "id") String departmentId) {
        departmentService.deleteRegisteredDepartment(departmentId);

        return ResponseEntity.status( HttpStatus.OK )
                .body(
                        "Deleted Department With Department Id ==> " + departmentId + " Successfully"
                ) ;

    }
}
