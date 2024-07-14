package me.sailer.my_atelier.service;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.ProductImage;
import me.sailer.my_atelier.repository.ProductImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public List<ProductImage> findByProductNo(Long productNo) {
        return productImageRepository.findByProduct_productNo(productNo);
    }
}
