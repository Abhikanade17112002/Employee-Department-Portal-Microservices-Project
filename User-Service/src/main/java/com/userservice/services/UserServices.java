package com.userservice.services;

import com.userservice.dtos.RegisterUserRequestDTO;
import com.userservice.dtos.RegisterUserResponseDTO;
import com.userservice.dtos.UserResponseDTO;
import com.userservice.entities.User;
import com.userservice.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository ;

    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO user ){
        User newUser = new User() ;

        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());

        User registeredUser = userRepository.save(newUser) ;

        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO() ;
        registerUserResponseDTO.setEmail(registeredUser.getEmail());
        registerUserResponseDTO.setFirstName(registeredUser.getFirstName());
        registerUserResponseDTO.setLastName(registeredUser.getLastName());
        registerUserResponseDTO.setUserId(registeredUser.getUserId());

        return registerUserResponseDTO;
    }

    public List<UserResponseDTO> getAllRegisteredUsers() {

        List<User> retrivedUsers = userRepository.findAll() ;

        List<UserResponseDTO> response = retrivedUsers.stream().map(
                ( registeredUser ) ->{

                    UserResponseDTO registerUserResponseDTO = new UserResponseDTO() ;

                    registerUserResponseDTO.setEmail(registeredUser.getEmail());
                    registerUserResponseDTO.setFirstName(registeredUser.getFirstName());
                    registerUserResponseDTO.setLastName(registeredUser.getLastName());
                    registerUserResponseDTO.setUserId(registeredUser.getUserId());

                    return registerUserResponseDTO;

                }
        ).toList();

        return response ;
    }

    public UserResponseDTO getRegisteredUserById(String userId) {

        User retrivedUser = userRepository.findById( userId ).orElseThrow( ()->
                new EntityNotFoundException("User With User Id ==> " + userId + " Not Found")) ;

        UserResponseDTO response = new UserResponseDTO() ;

        response.setEmail(retrivedUser.getEmail());
        response.setFirstName(retrivedUser.getFirstName());
        response.setLastName(retrivedUser.getLastName());
        response.setUserId(retrivedUser.getUserId());

        return response ;
    }
}
