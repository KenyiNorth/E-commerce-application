package com.kenyi.ecommerce.service;

import com.kenyi.ecommerce.entity.Products;
import com.kenyi.ecommerce.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    private Repository repository;
    @Autowired
    public ProductService(Repository repository){
        this.repository=repository;
    }



    //insert products
    public Products saveProducts(Products products){
        products.setName(products.getName());
        products.setQuantity(products.getQuantity());
        products.setPrice(products.getPrice());
        return repository.save(products);

    }

    //Get list of products
    public List<Products> productsList(){
        return  repository.findAll();
    }

    //find by Id
    public Products findProductById(Long id){
        return repository.findById(id).orElse(null);
    }
    //Delete Products
    public void deleteById(Long id){
         repository.deleteById(id);
    }

    //Update products
    public ResponseEntity<Products> updateProducts(Products products){
        repository.findById(products.getId());
        products.setId(products.getId());
        products.setName(products.getName());
        products.setPrice(products.getPrice());
        products.setQuantity(products.getQuantity());
        return new ResponseEntity<>(repository.save(products), HttpStatus.OK);
    }

    public Products findByName(String name){
        return repository.findByName(name);
    }
}
