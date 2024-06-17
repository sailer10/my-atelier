package me.sailer.my_atelier.service;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.AddProductRequest;
import me.sailer.my_atelier.dto.UpdateProductRequest;
import me.sailer.my_atelier.repository.CategoryRepository;
import me.sailer.my_atelier.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product save(AddProductRequest request) {
        byte categoryId = request.getCategoryId();
        long sellerId = request.getSellerId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("wrong category id: " + categoryId));


        return productRepository.save(request.toEntity(category));
    }

    public Product update(long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong product id"));
        byte category_id = request.getCategoryId() != 0 ? request.getCategoryId() : product.getCategory().getCategoryNo();
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new IllegalArgumentException("Wrong category id"));

        product.update(
                request.getName() != null ? request.getName() : product.getName(),
                request.getPrice() != 0 ? request.getPrice() : product.getPrice(),
                request.getRemaining() != 0 ? request.getRemaining() : product.getRemaining(),
                request.isDiscounted(),
                request.getDiscountedPrice() != 0 ? request.getDiscountedPrice() : product.getDiscountedPrice(),
                request.getCategoryId() != 0 ? category : product.getCategory());

        return product;
    }

    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
