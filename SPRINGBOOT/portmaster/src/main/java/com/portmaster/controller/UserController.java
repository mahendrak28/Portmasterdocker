package com.portmaster.controller;


import com.portmaster.entity.User;
import com.portmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/getUser")
    public List<User> getPortfolio() {
        return userService.getUser();
    }

    /*@RequestMapping(value ="/getUser", method = RequestMethod.POST)
    public void createUser(@RequestBody byte[] user) throws IOException {
        byte[] mapData = user;
        User[] userStaticArray =null;

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        userStaticArray = objectMapper.readValue(mapData,User[].class);
        List<User> userList = Arrays.asList(userStaticArray);
                for (User userL :  userList){
            userService.createUser(userL);
        }
    }*/

        @RequestMapping(value ="/getUser", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) throws IOException {
           // user.setLastUpdateUser("SYSTEM");
            //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //System.out.println(timestamp);
            //user.setLastUpdateDate(timestamp);
           // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.createUser(user);
        }
/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new ServletException("User email not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }*/

}
