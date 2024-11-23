package com.hunny.springbootjdbc;

import com.hunny.springbootjdbc.model.Student;
import com.hunny.springbootjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootJdbcApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(SpringBootJdbcApplication.class, args);

        Student s= context.getBean(Student.class);
        s.setName("Hunny");
        s.setRollNo(33);
        s.setsid(99);
        StudentService service= context.getBean(StudentService.class);

        service.AddStudent(s);

        List<Student> ls= service.fetchStudent();

        for(Student student:ls){
            System.out.println(student);
        }


    }



}
