package me.sailer.my_atelier.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.AddProductRequest;
import me.sailer.my_atelier.repository.CategoryRepository;
import me.sailer.my_atelier.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Transactional
    public Product save(AddProductRequest request) {
        byte categoryId = request.getCategoryId();
        long sellerId = request.getSellerId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("wrong category id." + categoryId));

        return productRepository.save(request.toEntity(category));
    }

    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
