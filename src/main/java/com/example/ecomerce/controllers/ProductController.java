package com.example.ecomerce.controllers;

import com.example.ecomerce.model.Product;
import com.example.ecomerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    // inject dependencies
    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices=productServices;
    }

    @GetMapping("")
    public List<Product> getProducts(){
        return productServices.getAllProducts();
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("Testing");
        return "Test";
    }


    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Integer productId){
        Product foundProduct = productServices.findById(productId);
        if(foundProduct == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return foundProduct;
    }

    @DeleteMapping("/{productId}")
        public void deleteProductById(@PathVariable Integer productId){
         productServices.deleteProductById(productId);
    }


    @PostMapping("")
    public Product createNewProduct(@RequestBody @Validated Product product){
        return productServices.createNewProduct(product);
    }
}
