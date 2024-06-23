package me.sailer.my_atelier.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.domain.Atelier;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.enums.ProductStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {


    private Byte category_no;
    private Long atelier_no;
    private String name;
    private int price;
    private int remaining;
    private String description;

    public Product toEntity(Category category, Atelier atelier) {
        return Product.builder()
                .category(category)
                .atelier(atelier)
                .name(name)
                .price(price)
                .remaining(remaining)
                .description(description)
                .build();
    }
}
