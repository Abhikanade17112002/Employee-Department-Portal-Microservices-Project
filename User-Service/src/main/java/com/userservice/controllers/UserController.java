package com.userservice.controllers;

import com.userservice.dtos.*;
import com.userservice.feingclients.DepartmentClient;
import com.userservice.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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

    int retryCount = 1 ;

    @GetMapping("/{id}/withdepartment")
    @Retry(name = "FetchRegisteredUserByIdWithDepartment" , fallbackMethod = "fetchRegisteredUserByIdWithDepartmentFallback")
    @CircuitBreaker(name = "FetchRegisteredUserByIdWithDepartment" , fallbackMethod = "fetchRegisteredUserByIdWithDepartmentFallback")
    public ResponseEntity<UserDepartmentResponseDTO> getRegisterUserByIdAndDepartment(@PathVariable( name = "id") String userId ){
        System.out.println("RETRY COUNT ==> " + retryCount++);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        userServices.getRegisterUserByIdAndDepartment( userId )
                ) ;
    }



    public ResponseEntity<UserDepartmentResponseDTO> fetchRegisteredUserByIdWithDepartmentFallback( String userId , Exception e){
        System.out.println("fetchRegisteredUserByIdWithDepartmentFallback Called ==> " + e.getMessage());
        UserDepartmentResponseDTO dummyResponse = new UserDepartmentResponseDTO() ;

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                dummyResponse
        ) ;
    }



}
