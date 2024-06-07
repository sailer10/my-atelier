package me.sailer.my_atelier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddProductRequest {
    private String name;
    private int price;
    private int remaining;
    private int catagoryId;

    public Product toEntity(Category category) {
        return Product.builder()
                .name(name)
                .price(price)
                .remaining(remaining)
                .category(category)
                .build();
    }
}