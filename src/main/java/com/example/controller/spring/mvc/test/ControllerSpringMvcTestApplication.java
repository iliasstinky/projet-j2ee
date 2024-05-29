package com.example.controller.spring.mvc.test;

import com.example.controller.spring.mvc.test.doa.Entities.Product;
import com.example.controller.spring.mvc.test.doa.Entities.ProjectTask;
import com.example.controller.spring.mvc.test.doa.repositories.Productrepositories;
import com.example.controller.spring.mvc.test.doa.repositories.ProjectTaskrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControllerSpringMvcTestApplication implements CommandLineRunner {

	@Autowired
	private Productrepositories pr;
	@Autowired
	private ProjectTaskrepo pro;


	public static void main(String[] args) {
		SpringApplication.run(ControllerSpringMvcTestApplication.class, args);
	}


    ProjectTask proo = new ProjectTask(1 , "dd" , "jfjf", "Done");
	ProjectTask pro1 = new ProjectTask(2 , "ff" , "fefefe", "In Progress");

	@Override
	public void run(String... args) throws Exception {


		 pro.save(proo);
		 pro.save(pro1);
	}
}
