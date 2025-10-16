package com.departmentservice.services;

import com.departmentservice.dtos.DepartmentRequestDTO;
import com.departmentservice.dtos.DepartmentResponseDTO;
import com.departmentservice.dtos.UpdateDepartmentRequestDTO;
import com.departmentservice.entities.Department;
import com.departmentservice.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
     @Autowired
     private DepartmentRepository departmentRepository;


    public DepartmentResponseDTO registerDepartment(DepartmentRequestDTO department) {

        Department newDepartment = new Department() ;
        newDepartment.setDepartmentName(department.getDepartmentName().toUpperCase());
        newDepartment.setDescription(department.getDescription());

        Department registeredDepartment = departmentRepository.save( newDepartment ) ;
        DepartmentResponseDTO response = new DepartmentResponseDTO() ;
        response.setDepartmentId(registeredDepartment.getDepartmentId());
        response.setDepartmentName(registeredDepartment.getDepartmentName());
        response.setDescription(registeredDepartment.getDescription());

        return response ;

    }

    public List<DepartmentResponseDTO> getAllRegisteredDepartments() {
        List<DepartmentResponseDTO> response = departmentRepository.findAll()
                .stream()
                .map( (department)->{
                    DepartmentResponseDTO res = new DepartmentResponseDTO() ;
                    res.setDepartmentId(department.getDepartmentId());
                    res.setDepartmentName(department.getDepartmentName());
                    res.setDescription(department.getDescription());

                    return res ;
                }).toList() ;

        return response ;
    }

    public DepartmentResponseDTO getRegisteredDepartmentById(String departmentId) {

        Department retrivedDepartmet = departmentRepository.findById( departmentId )
                .orElseThrow( ()-> new EntityNotFoundException("Depart With Department Id ==> " + departmentId + " Not Found ")) ;

        DepartmentResponseDTO response = new DepartmentResponseDTO() ;
        response.setDepartmentId(retrivedDepartmet.getDepartmentId());
        response.setDepartmentName(retrivedDepartmet.getDepartmentName());
        response.setDescription(retrivedDepartmet.getDescription());

        return response ;
    }

    public DepartmentResponseDTO updateRegisteredDepartment(String departmentId, @Valid UpdateDepartmentRequestDTO updatedDept) {

        Department retrivedDepartment = departmentRepository.findById( departmentId )
                .orElseThrow( () ->  new EntityNotFoundException("Department Does Not Exists With Id ==> " + departmentId + " To Update") );

        retrivedDepartment.setDescription( updatedDept.getDescription() != null ? updatedDept.getDescription() : retrivedDepartment.getDescription());
        retrivedDepartment.setDepartmentName(updatedDept.getDepartmentName() != null ? updatedDept.getDepartmentName().toUpperCase() : retrivedDepartment.getDepartmentName());

        Department updatedDepartment = departmentRepository.save( retrivedDepartment ) ;

        DepartmentResponseDTO response = new DepartmentResponseDTO(  ) ;

        response.setDescription(updatedDepartment.getDescription());
        response.setDepartmentId(updatedDepartment.getDepartmentId());
        response.setDepartmentName(updatedDepartment.getDepartmentName());

        return response ;

    }

    public void deleteRegisteredDepartment(String departmentId) {

        if( !departmentRepository.existsById(departmentId) ){
            throw  new EntityNotFoundException("Department With Department Id ==> " + departmentId + " Not Found To Be Deleted") ;
        }
        else{
            departmentRepository.deleteById(departmentId);

            return ;

        }


    }
}

