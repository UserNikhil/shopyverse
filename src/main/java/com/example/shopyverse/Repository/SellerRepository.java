package com.example.shopyverse.Repository;

import com.example.shopyverse.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

    public Seller findByEmailId(String email);
}