package com.example.shopyverse.Transformer;

import com.example.shopyverse.Dto.Response.CartResponseDto;
import com.example.shopyverse.Dto.Response.ItemResponseDto;
import com.example.shopyverse.Model.Cart;
import com.example.shopyverse.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {
    public static CartResponseDto CartToCartReponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtoList)
                .build();
    }
}
