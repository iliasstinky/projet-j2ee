package com.example.controller.spring.mvc.test.doa.repositories;

import com.example.controller.spring.mvc.test.doa.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepositories extends JpaRepository<Product , Integer> {
    Product findById(int id);

}
