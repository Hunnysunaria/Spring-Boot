package com.hunny.springbootjdbc.service;

import com.hunny.springbootjdbc.model.Student;
import com.hunny.springbootjdbc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public void AddStudent(Student s) {
       repo.save(s);
    }

    public StudentRepo getRepo() {
        return repo;
    }

@Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }


    public List<Student> fetchStudent() {

        return repo.getStudent();
    }
}
