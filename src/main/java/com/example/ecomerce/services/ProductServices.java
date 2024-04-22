package com.example.ecomerce.services;

import com.example.ecomerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServices {

    private static Map<String, Product> productList= new HashMap<>(){{
        put("1", new Product("1","product1",1));
    }};


    public  static Collection<Product> get() {
        return productList.values();
    }

    public static Product get(String productId) {
        return productList.get(productId);
    }

    public static Product put(String productName, int productPrice) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        productList.put(product.getId(),product );
        return product;
    }

    public Product remove(String productId) {
        return productList.remove(productId);
    }

}
