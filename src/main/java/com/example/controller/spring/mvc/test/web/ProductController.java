package com.example.controller.spring.mvc.test.web;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.controller.spring.mvc.test.Business.produitmanagerrepository;
import jakarta.persistence.Id;
import org.springframework.ui.Model;
import com.example.controller.spring.mvc.test.doa.Entities.Product;
import com.example.controller.spring.mvc.test.doa.repositories.Productrepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {



    @Autowired
    Productrepositories pr;
    @Autowired

    produitmanagerrepository pro;


    @GetMapping("/List")
    public String showproduit(Model model){

      List<Product> list_produit = pr.findAll();

     model.addAttribute("list_produit", list_produit);


        return "Products/Product";
    }

    @GetMapping("/Listsort")
    public String showproduitsort(Model model , @RequestParam(name = "price" , defaultValue = "price") String price ){

        List<Product> list_produit = pr.findAll(Sort.by(Sort.Direction.ASC, price));

        model.addAttribute("list_produit", list_produit);


        return "Products/Product";
    }
    @GetMapping("/Form")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "Forms/Form";
    }


    @GetMapping("/Formedit")
    public String editForm(@RequestParam(name = "id") int id, Model model) {



        Product produit =  pro.getProductbyId(id);
        if (produit != null) {
            model.addAttribute("producto", produit);
            return "Forms/Form_edit";
        } else {
            return "error";
        }

    }

    @GetMapping("/Productdelete")
    public String deleteProduit(Model model, @RequestParam(name = "id") int id) {



        if  (pro.deleteProduit(id)) {

            return "redirect:List";
        } else {
            return "error";
        }
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        pr.save(product); // Save the product data
        return "redirect:List"; // Redirect to a page showing the list of products
    }

    @PostMapping("/save_edited_Product")
    public String save_edited_Product(@ModelAttribute("producto") Product produit) {
        pr.save(produit); // Save the product data
        return "redirect:List"; // Redirect to a page showing the list of products
    }



}



