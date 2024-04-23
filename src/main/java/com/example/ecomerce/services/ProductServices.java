package com.example.ecomerce.services;

import com.example.ecomerce.model.Product;
import com.example.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        // todo: add pagination, sort, filtering
         return productRepository.findAll();
    }

    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Integer productId){
        return productRepository.findById(productId).orElse(null);
    }

    public void deleteProductById(Integer productId){
        productRepository.deleteById(productId);
    }
}
