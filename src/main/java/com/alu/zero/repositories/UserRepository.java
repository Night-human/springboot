package com.alu.zero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alu.zero.models.Gender;
import com.alu.zero.models.User;
import com.alu.zero.services.dtos.UserDTO;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByGender(Gender gender);

    @Modifying
    @Transactional
    @Query(value="UPDATE User u SET" +
    " u.name=:#{#user.getName()}," +
    " u.lastName=:#{#user.getLastName()}," +
    " u.gender=:#{#user.getGender()}," +
    " u.age=:#{#user.getAge()}" +
    " WHERE u.userId = :userId")
    public void updateUser(@Param("userId") Long userId, @Param("user") UserDTO user);
}
