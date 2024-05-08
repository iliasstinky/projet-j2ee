package com.example.controller.spring.mvc.test.Business;

import com.example.controller.spring.mvc.test.doa.Entities.Product;
import com.example.controller.spring.mvc.test.doa.repositories.Productrepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class Produitmanagerbusiness implements produitmanagerrepository{
    @Autowired
    private Productrepositories productrepositories;
    @Override
    public Product getProductbyId(int id) {
        return productrepositories.findById(id);
    }

    @Override
    public boolean deleteProduit(int id) {
        try {
            productrepositories.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }



}
