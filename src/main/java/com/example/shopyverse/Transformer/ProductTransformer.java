package com.example.shopyverse.Transformer;

import com.example.shopyverse.Dto.Request.ProductRequestDto;
import com.example.shopyverse.Dto.Response.ProductResponseDto;
import com.example.shopyverse.Enum.ProductStatus;
import com.example.shopyverse.Model.Product;

public class ProductTransformer {
    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .availableQuantity(productRequestDto.getAvailableQuantity())
                .category(productRequestDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){

        return ProductResponseDto.builder()
                .sellerName(product.getSeller().getName())
                .productName(product.getProductName())
                .productStatus(product.getProductStatus())
                .price(product.getPrice())
                .category(product.getCategory())
                .availableQuantity(product.getAvailableQuantity())
                .build();
    }
}
