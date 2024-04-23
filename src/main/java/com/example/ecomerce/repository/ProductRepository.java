package com.example.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecomerce.model.Product;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
