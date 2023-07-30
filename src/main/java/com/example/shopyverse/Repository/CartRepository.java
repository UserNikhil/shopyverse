package com.example.shopyverse.Repository;

import com.example.shopyverse.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}