package com.alu.zero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alu.zero.models.Gender;
import com.alu.zero.models.User;
import com.alu.zero.services.UserService;
import com.alu.zero.services.dtos.UserDTO;



@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO findUsersById(@PathVariable Long userId) {
        return userService.findUsersById(userId);
    }

    @GetMapping("/gender/{gender}")
    public List<UserDTO> getMethodName(@PathVariable Gender gender) {
        return userService.findByGender(gender);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public UserDTO createUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return userService.updateUser(userId, userDTO);
    }
    
}
