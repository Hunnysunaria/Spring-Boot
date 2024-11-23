package com.hunny.spring_sec_demo.service;

import com.hunny.spring_sec_demo.dao.UserRepo;
import com.hunny.spring_sec_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);


    public User saveUser(User user){
        System.out.println(user);
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }

}
