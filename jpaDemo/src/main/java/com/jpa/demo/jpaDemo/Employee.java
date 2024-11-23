package com.jpa.demo.jpaDemo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class Employee {

    @Id
    private int eid;
    private String ename;
    private int marks;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "EmployeeRepo{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", marks=" + marks +
                '}';
    }

}
