package com.example.shopyverse.Repository;

import com.example.shopyverse.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRespository extends JpaRepository<Card,Integer> {

    public Card findByCardNo(String cardNo);
}