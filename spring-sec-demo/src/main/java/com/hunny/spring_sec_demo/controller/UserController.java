package com.hunny.spring_sec_demo.controller;

import com.hunny.spring_sec_demo.model.User;
import com.hunny.spring_sec_demo.service.JwtService;
import com.hunny.spring_sec_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
    JwtService jwtService;
    @Autowired
    private UserService userservice;

    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("register")
    public User register(@RequestBody User user){
        return userservice.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
     Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()){
        return jwtService.generateUserToken(user.getUsername());
    }
    return "Failed";
    }
}
