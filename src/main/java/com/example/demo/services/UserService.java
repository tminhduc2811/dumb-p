package com.example.demo.services;


import com.example.demo.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User createUser(User user);

    User getUser(Long id);
}
