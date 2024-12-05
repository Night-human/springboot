package com.alu.zero.mappers;

import java.util.ArrayList;
import java.util.List;

import com.alu.zero.models.User;
import com.alu.zero.services.dtos.UserDTO;

public class UserToUserDTO implements IMapper<User, UserDTO>{

    @Override
    public UserDTO map(User user) {
        return mapUser(user);
    }

    @Override
    public List<UserDTO> map(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user: users){
            userDTOs.add(mapUser(user));
        }
        
        return userDTOs;
    }

    private UserDTO mapUser(User user) {
        UserDTO userDTO = new UserDTO(
            user.getUserId(),
            user.getName(),
            user.getLastName(),
            user.getGender(),
            user.getAge()
        );

        return userDTO;
    }
    
}
