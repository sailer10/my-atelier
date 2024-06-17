package me.sailer.my_atelier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.sailer.my_atelier.domain.Category;

/**
 * 제품 태그 제외 변경 DTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UpdateProductRequest {

    private String name;
    private int price;
    private int remaining;
    private boolean isDiscounted;
    private int discountedPrice;
    private byte categoryId;

}
