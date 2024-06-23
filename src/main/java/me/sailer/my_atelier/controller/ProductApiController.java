package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.product.AddProductRequest;
import me.sailer.my_atelier.dto.product.ProductResponse;
import me.sailer.my_atelier.service.ProductService;
import me.sailer.my_atelier.util.STS;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(STS.API_PRODUCTS)
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(new ProductResponse(product));
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequest request) {
        Product product = productService.saveProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }




}
