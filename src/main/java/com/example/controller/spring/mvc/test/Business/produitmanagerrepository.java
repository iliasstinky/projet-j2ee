package com.example.controller.spring.mvc.test.Business;

import com.example.controller.spring.mvc.test.doa.Entities.Product;

public interface produitmanagerrepository {
    public Product getProductbyId(int id);


    public boolean deleteProduit(int id);


}
