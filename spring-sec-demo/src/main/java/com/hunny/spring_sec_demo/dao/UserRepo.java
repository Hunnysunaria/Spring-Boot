package com.hunny.spring_sec_demo.dao;

import com.hunny.spring_sec_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    User findByUsername(String username);
}