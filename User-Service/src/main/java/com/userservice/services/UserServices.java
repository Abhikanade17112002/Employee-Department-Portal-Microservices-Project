package com.userservice.services;

import com.userservice.dtos.*;
import com.userservice.entities.Department;
import com.userservice.entities.User;
import com.userservice.feingclients.DepartmentClient;
import com.userservice.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class UserServices {
    @Autowired
    private DepartmentClient departmentClient ;

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
        registerUserResponseDTO.setAge(registeredUser.getAge());


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
                    registerUserResponseDTO.setAge(registeredUser.getAge());

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
        response.setAge(retrivedUser.getAge());

        return response ;
    }

    public void deleteRegisteredUserById(String userId) {

        if( !userRepository.existsById(userId) ){
            throw  new EntityNotFoundException("User With User Id ==> " + userId + " Not Found To Delete ") ;
        }

        userRepository.deleteById(userId);
        return ;
    }

    public UserResponseDTO updateRegisteredUserById(String userId, @Valid UpdateUserRequestDTO updatedUser) {

        User retrivedUser = userRepository.findById(userId).orElseThrow( ()->  new EntityNotFoundException("User With User Id ==> " + userId + " Not Found To Update ")) ;

        retrivedUser.setFirstName(updatedUser.getFirstName() != null ? updatedUser.getFirstName() : retrivedUser.getFirstName());
        retrivedUser.setLastName( updatedUser.getLastName() != null ? updatedUser.getLastName() : retrivedUser.getLastName() );
        retrivedUser.setEmail( updatedUser.getEmail() != null ? updatedUser.getEmail() : retrivedUser.getEmail());
        retrivedUser.setAge( updatedUser.getAge() != 0 ? updatedUser.getAge() : retrivedUser.getAge());
        retrivedUser.setDepartmentId(updatedUser.getDepartmentId() != null ? updatedUser.getDepartmentId() : retrivedUser.getDepartmentId());

        User user = userRepository.save(retrivedUser) ;


        UserResponseDTO response = new UserResponseDTO() ;

        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setUserId(user.getUserId());
        response.setAge(user.getAge());

        return response ;

    }

    public UserDepartmentResponseDTO getRegisterUserByIdAndDepartment(String userId) {

        User retrivedUser =  userRepository.findById( userId  ).orElseThrow(
                ()-> new EntityNotFoundException("User with user Id ==> " + userId + " Not Found ")
        ) ;

        Department retrivedDepartment = departmentClient.getDepartmentById(retrivedUser.getDepartmentId()) ;

        UserDepartmentResponseDTO response = new UserDepartmentResponseDTO() ;
        response.setUser(retrivedUser);
        response.setDepartment(retrivedDepartment);

        return response ;


    }
}
