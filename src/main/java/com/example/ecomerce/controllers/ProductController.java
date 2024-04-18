package com.example.ecomerce.controllers;

import com.example.ecomerce.entities.ProductEntity;
import com.example.ecomerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/users")
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
    public Collection<ProductEntity> getAllProducts(){
        return ProductServices.get();
    }

    @GetMapping("/{productId}")
    public ProductEntity getProductById(@PathVariable String productId){
        ProductEntity foundProduct = ProductServices.get(productId);
        if(foundProduct == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return foundProduct;
    }

    @DeleteMapping("/{productId}")
        public void deleteProductById(@PathVariable String productId){
        ProductEntity product= productServices.remove(productId);
        if(product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    @PostMapping("/")
    public ProductEntity createNewProduct(@RequestBody @Validated String productName, int productPrice){
        return ProductServices.put(productName,productPrice );

    }
}
