package com.istad.friendlyjwt.service.serviceImpl;

import com.istad.friendlyjwt.repository.UserRepository;
import com.istad.friendlyjwt.model.User;
import com.istad.friendlyjwt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository =userRepository;
    }
    @Override
    public List<User> findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

}
