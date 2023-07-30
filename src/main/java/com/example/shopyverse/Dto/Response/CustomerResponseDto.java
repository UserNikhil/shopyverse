package com.example.shopyverse.Dto.Response;

import com.example.shopyverse.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponseDto {
    String name;

    String emailId;

    String mobNo;

    Gender gender;
}
