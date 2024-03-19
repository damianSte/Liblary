package com.damian.application.liblary.service;


import com.damian.application.liblary.DTOs.UserDTO.CreateUserDTO;
import com.damian.application.liblary.DTOs.UserDTO.CreateUserResponseDTO;
import com.damian.application.liblary.DTOs.UserDTO.GetUserDTO;
import com.damian.application.liblary.infrastucture.entity.UserEntity;
import com.damian.application.liblary.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GetUserDTO> getAll(){
        var users= userRepository.findAll();
        return users.stream().map((user)-> new GetUserDTO(user.getUser_id(),user.getUsername(),user.getPassword(),user.getRole(),user.getEmail(),user.getName())).collect(Collectors.toList());
    }

    public GetUserDTO getOne(long user_id){
        var user= userRepository.findById(user_id).orElseThrow(()-> new RuntimeException("User not found"));
        return new GetUserDTO(user.getUser_id(),user.getUsername(),user.getPassword(),user.getRole(),user.getEmail(),user.getName());
    }

    public CreateUserResponseDTO create(CreateUserDTO user){
        var userEntity= new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());

        var newUser= userRepository.save(userEntity);

        return new CreateUserResponseDTO(newUser.getUser_id(),newUser.getUsername(),newUser.getPassword(),user.getRole(),user.getEmail(),user.getName());
    }

    public void delete(long user_id){
        if(!userRepository.existsById(user_id)){
            throw new RuntimeException();
        }
        userRepository.deleteById(user_id);
    }


}