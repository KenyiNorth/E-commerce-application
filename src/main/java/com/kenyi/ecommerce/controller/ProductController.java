package com.kenyi.ecommerce.controller;

import com.kenyi.ecommerce.entity.Products;
import com.kenyi.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping( "/insert")
    public Products saveProducts(@RequestBody Products products){
        return productService.saveProducts(products);

    }
    

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Products> productList(){
        return productService.productsList();
    }
    /*
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Products updateProducts(Products products){
        return productService.updateProducts(products);
    }

     */

    //Update for RequestMethod.Get

    @PutMapping("/update")
    public ResponseEntity<Products> updateProducts(@RequestBody Products products){
        return productService.updateProducts(products);

    }

    @RequestMapping(value = "/findId/{id}",method = RequestMethod.GET)
    public Products findById(@PathVariable("id") Long id){
        return productService.findProductById(id);

    }
    @RequestMapping(value = "/findName/{name}",method = RequestMethod.GET)
    public Products findByName(@PathVariable("name") String name){
        return productService.findByName(name);

    }
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduts(@PathVariable("id") Long id){
        productService.deleteById(id);
    }
}
