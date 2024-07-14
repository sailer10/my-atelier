package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.dto.product.ProductDetailResponse;
import me.sailer.my_atelier.dto.productImage.ProductImagesResponse;
import me.sailer.my_atelier.service.ProductImageService;
import me.sailer.my_atelier.util.Urls;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestApiController {
    private final ProductImageService productImageService;

    @GetMapping(Urls.PRODUCT_IMAGES + "/{productNo}")
    public ResponseEntity<List<ProductImagesResponse>> getProductImages(@PathVariable(name = "productNo") Long productNo) {
        List<ProductImagesResponse> responses = productImageService.findByProductNo(productNo).stream()
                .map(productImage -> new ProductImagesResponse(productImage, productNo)).toList();

        return ResponseEntity.ok().body(responses);
    }
}
