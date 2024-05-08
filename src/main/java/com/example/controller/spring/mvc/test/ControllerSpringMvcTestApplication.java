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

	Product product1 = new Product(1 ,"dd" , 1 , 4);
	Product product2 = new Product(2, "vv" , 2 , 5);
    ProjectTask proo = new ProjectTask(1 , "dd" , "jfjf", "Done");
	@Override
	public void run(String... args) throws Exception {

		pr.save(product1);
		pr.save(product2);
		 pro.save(proo);
	}
}
