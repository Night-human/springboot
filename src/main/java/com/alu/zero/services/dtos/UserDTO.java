package com.alu.zero.services.dtos;

import com.alu.zero.models.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String name;
    private String lastName;
    private Gender gender;
    private byte age;
}
