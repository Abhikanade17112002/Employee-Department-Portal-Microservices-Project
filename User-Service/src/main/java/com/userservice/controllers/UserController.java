package com.userservice.controllers;

import com.userservice.dtos.*;
import com.userservice.feingclients.DepartmentClient;
import com.userservice.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices ;

    @PostMapping
    public ResponseEntity<RegisterUserResponseDTO> registerUser(@Valid @RequestBody RegisterUserRequestDTO user ){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                      userServices.registerUser(user)
                ) ;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllRegisteredUsers(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        userServices.getAllRegisteredUsers()
                ) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getRegisteredUserById(@PathVariable(name = "id") String userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        userServices.getRegisteredUserById( userId )
                ) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegisteredUserById( @PathVariable(name = "id") String userId ){

        userServices.deleteRegisteredUserById( userId ) ;

        return ResponseEntity.status(HttpStatus.OK).build() ;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateRegisteredUserById(@Valid @RequestBody UpdateUserRequestDTO updatedUser , @PathVariable( name = "id") String userId ){

        return ResponseEntity.status(HttpStatus.OK).body(
                userServices.updateRegisteredUserById( userId , updatedUser )
        ) ;
        
    }

    @GetMapping("/{id}/withdepartment")
    public ResponseEntity<UserDepartmentResponseDTO> getRegisterUserByIdAndDepartment(@PathVariable( name = "id") String userId ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        userServices.getRegisterUserByIdAndDepartment( userId )
                ) ;
    }



}
