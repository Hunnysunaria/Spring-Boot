package com.hunny.springbootjdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
private int rollNo;
private int sid;
private String Name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getsid() {
        return sid;
    }

    public void setsid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Student ID=" + sid +
                ", rollNo=" + rollNo +", Name='" + Name + '\'' +
                '}';
    }
}
