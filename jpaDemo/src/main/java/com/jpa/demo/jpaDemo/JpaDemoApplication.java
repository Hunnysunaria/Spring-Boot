package com.jpa.demo.jpaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {


	ApplicationContext context= SpringApplication.run(JpaDemoApplication.class, args);
		EmployeeRepo repo=context.getBean(EmployeeRepo.class);
	Employee e1= context.getBean(Employee.class);
		Employee e2= context.getBean(Employee.class);
		Employee e3= context.getBean(Employee.class);
e1.setEid(1);
e1.setEname("Hunny");
e1.setMarks(23);


		e2.setEid(2);
		e2.setEname("Funny");
		e2.setMarks(28);


		e3.setEid(3);
		e3.setEname("Sunny");
		e3.setMarks(25);

repo.save(e1);
repo.save(e2);
repo.save(e3);
repo.findAll();



	}

}
