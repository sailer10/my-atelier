package me.sailer.my_atelier.service;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.AddProductRequest;
import me.sailer.my_atelier.repository.CategoryRepository;
import me.sailer.my_atelier.repository.ProductRepository;
import me.sailer.my_atelier.repository.SiteUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product save(AddProductRequest request) {
        System.out.println(request.toString());
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("wrong category id."));

        return productRepository.save(request.toEntity(category));
    }

    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
