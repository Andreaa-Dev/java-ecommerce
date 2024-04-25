package com.example.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecomerce.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
