package com.example.ecomerce.entities;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductEntity {
    private String id;
    @NotNull
    private String productName;

    @Size(min = 1, max = 100)
    private int price;


    public ProductEntity(){

    }

    public ProductEntity(String id, String productName, int price) {
        this.id=id;
        this.productName=productName;
        this.price=price;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
