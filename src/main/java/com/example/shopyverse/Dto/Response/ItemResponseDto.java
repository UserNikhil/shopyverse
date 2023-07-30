package com.example.shopyverse.Dto.Response;

import com.example.shopyverse.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {
    String itemName;

    int itemPrice;

    int quantityAdded;

    ProductCategory category;
}
