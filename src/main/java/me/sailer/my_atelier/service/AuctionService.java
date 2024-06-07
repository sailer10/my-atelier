package me.sailer.my_atelier.service;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.AddProductRequest;
import me.sailer.my_atelier.repository.CategoryRepository;
import me.sailer.my_atelier.repository.ProductRepository;
import me.sailer.my_atelier.repository.SiteUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private ProductRepository productRepository;
    private SiteUserRepository siteUserRepository;
    private CategoryRepository categoryRepository;

    public Product save(AddProductRequest request) {
        Category category = categoryRepository.findById(request.getCatagoryId())
                .orElseThrow(() -> new IllegalArgumentException("wrong category id."));

        return productRepository.save(request.toEntity(category));
    }

    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
