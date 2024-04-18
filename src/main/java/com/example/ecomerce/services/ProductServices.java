package com.example.ecomerce.services;

import com.example.ecomerce.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServices {

    private static Map<String, ProductEntity> productList= new HashMap<>(){{
        put("1", new ProductEntity("1","product1",1));
    }};


    public  static Collection<ProductEntity> get() {
        return productList.values();
    }

    public static ProductEntity get(String productId) {
        return productList.get(productId);
    }


    public static ProductEntity put( String productName, int productPrice) {
        ProductEntity product = new ProductEntity();
        product.setId(UUID.randomUUID().toString());
        productList.put(product.getId(),product );
        return product;
    }

    public ProductEntity remove(String productId) {
        return productList.remove(productId);
    }

}
