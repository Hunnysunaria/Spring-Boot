package com.hunny.spring_sec_demo.controller;

import com.hunny.spring_sec_demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    List<Student> student= new ArrayList<>(
            List.of(new Student(1,"Hunny",99),
            new Student(2,"Sunny",98),
            new Student(3,"Rakesh",97)));


    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("students")
    public List<Student> allStudent(){
        return student;
    }

    @PostMapping("students")
    public void createStudent(@RequestBody Student student){
        this.student.add(student);
    }

}