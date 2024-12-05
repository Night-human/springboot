package com.alu.zero.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="t_user")
@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private String name;
    private String lastName;
    private Gender gender;
    private byte age;
    private String keepSecret;

    public User(String name, String lastName, Gender gender, byte age){
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }
}
