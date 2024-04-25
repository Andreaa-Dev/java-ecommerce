package com.example.ecomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;


    @NotNull
    private String productName;

    @Size(min = 1, max = 100)
    private Integer price;

    public Product() {}

    public Product(Integer id, String productName, Integer price) {
        this.id=id;
        this.productName=productName;
        this.price=price;
    }


}
