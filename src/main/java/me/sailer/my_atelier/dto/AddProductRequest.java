package me.sailer.my_atelier.dto;

import lombok.*;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AddProductRequest {
    private String name;
    private int price;
    private int remaining;
    private long categoryId;

    public Product toEntity(Category category) {
        return Product.builder()
                .name(name)
                .price(price)
                .remaining(remaining)
                .category(category)
                .build();
    }
}