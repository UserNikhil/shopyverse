package com.example.shopyverse.Repository;

import com.example.shopyverse.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}