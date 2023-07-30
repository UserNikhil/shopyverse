package com.example.shopyverse.Repository;

import com.example.shopyverse.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByMobNo(String customerMobile);

    Customer findByEmailId(String customerEmail);
}
