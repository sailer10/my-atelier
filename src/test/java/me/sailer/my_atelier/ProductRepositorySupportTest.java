package me.sailer.my_atelier;

import me.sailer.my_atelier.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositorySupportTest {

    @Test
    public void addProductTest() {
        Product p1 = Product.builder()
                .build();
    }
}
