package com.portmaster.service;

import com.portmaster.entity.PortStaticAttribute;
import com.portmaster.entity.User;
import com.portmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User>getUser(){
        return (List<User>) userRepository.findAll() ;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }


}
