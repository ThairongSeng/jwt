package com.istad.friendlyjwt.service;

import com.istad.friendlyjwt.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findUserByName(String username);
}
