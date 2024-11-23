package com.hunny.spring_sec_demo.service;

import com.hunny.spring_sec_demo.dao.UserRepo;
import com.hunny.spring_sec_demo.model.User;
import com.hunny.spring_sec_demo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= repo.findByUsername(username);
System.out.println(user);
        if(user==null){
            System.out.println("404");
            throw new UsernameNotFoundException("User 404");

        }

            return new UserPrincipal(user);



    }
}
