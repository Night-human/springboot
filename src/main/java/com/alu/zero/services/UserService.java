package com.alu.zero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alu.zero.common.exceptions.NotFoundException;
import com.alu.zero.common.response.ResponseMessages;
import com.alu.zero.mappers.UserToUserDTO;
import com.alu.zero.models.Gender;
import com.alu.zero.models.User;
import com.alu.zero.repositories.UserRepository;
import com.alu.zero.services.dtos.UserDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAllUsers() {
          
            UserToUserDTO userDTOinUserList = new UserToUserDTO();
            List<User> currentUserList = userRepository.findAll();   

            if(currentUserList.size() < 1) throw new NotFoundException(ResponseMessages.NOT_FOUND);

            return userDTOinUserList.map(currentUserList);
    }

    public UserDTO findUsersById(Long userId) {
        UserToUserDTO userToUserDTO = new UserToUserDTO();
        Optional<User> currentUser = userRepository.findById(userId);
        UserDTO user = null;

        if (currentUser.isPresent()) {
            user = userToUserDTO.map(currentUser.get());
        }

        return user;
    }

    public List<UserDTO> findByGender(Gender gender) {
        List<User> usersByGender = userRepository.findAllByGender(gender);
        UserToUserDTO userToUserDTO = new UserToUserDTO();
        List<UserDTO> userDTOs = userToUserDTO.map(usersByGender);

        return userDTOs;
    }

    public UserDTO createUser(User user) {
        UserToUserDTO userToUserDTO = new UserToUserDTO();
        user = userRepository.save(user);
        UserDTO userDTO = userToUserDTO.map(user);
        
        return userDTO;
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Optional<User> currentUser = userRepository.findById(userId);

        if (currentUser.isPresent()) {
            userRepository.updateUser(userId, userDTO);
        }

        return userDTO;
    }

}
