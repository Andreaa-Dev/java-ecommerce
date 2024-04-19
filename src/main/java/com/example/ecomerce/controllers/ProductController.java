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
@RequestMapping("v1/api/users")
public class ProductController {
    // inject dependencies
    private final ProductServices productServices;

    // way1
//    public ProductController(ProductServices productServices){
//
//        this.productServices=productServices;
//    }

    // way2
    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices=productServices;

    }

    @GetMapping("/")
    public Collection<Product> getAllProducts(){
        return ProductServices.get();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId){
        Product foundProduct = ProductServices.get(productId);
        if(foundProduct == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return foundProduct;
    }

    @DeleteMapping("/{productId}")
        public void deleteProductById(@PathVariable String productId){
        Product product= productServices.remove(productId);
        if(product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    @PostMapping("/")
    public Product createNewProduct(@RequestBody @Validated String productName, int productPrice){
        return ProductServices.put(productName,productPrice );

    }
}
