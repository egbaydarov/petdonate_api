package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Pet;
import com.example.postgresdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT user from User user where user.id=?1")
    List<User> getUserById(String userID);
}
