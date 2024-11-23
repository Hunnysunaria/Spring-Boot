package com.hunny.springbootjdbc.repo;

import com.hunny.springbootjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
@Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {


        String sql= "Insert into student values(?,?,?)";
        int rows= jdbc.update(sql,student.getsid(),student.getName(),student.getRollNo());
        System.out.println(rows+" Added");

    }


    public List<Student> getStudent() {

        String sql= "select * from student";

//        RowMapper<Student> mapper= new RowMapper<Student>() {
//
//            public Student mapRow(ResultSet rs, int rowNum)throws SQLException {
//                Student s= new Student();
//
//                s.setRollNo(rs.getInt(3));
//                s.setName(rs.getString(2) );
//                s.setsid(rs.getInt(1));
//                return s;
//            }
//
//        };


        RowMapper<Student> mapper= (ResultSet rs, int rowcount) ->{
                Student s= new Student();

                s.setRollNo(rs.getInt(3));
                s.setName(rs.getString(2) );
                s.setsid(rs.getInt(1));
                return s;
            

        };



        return jdbc.query(sql,mapper);
    }
}
