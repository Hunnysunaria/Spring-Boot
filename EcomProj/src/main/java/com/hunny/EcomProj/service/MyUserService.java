package com.hunny.EcomProj.service;

import com.hunny.EcomProj.model.User;
import com.hunny.EcomProj.model.UserPrincipal;
import com.hunny.EcomProj.repo.UserRepo;
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

       if(user==null){
           throw new UsernameNotFoundException("User Not FOUND 404");

       }
       return new UserPrincipal(user);
    }
}
