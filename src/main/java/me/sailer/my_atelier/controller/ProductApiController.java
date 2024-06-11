package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.AddProductRequest;
import me.sailer.my_atelier.dto.UpdateProductRequest;
import me.sailer.my_atelier.service.ProductService;
import me.sailer.my_atelier.statics.Statics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @PostMapping(Statics.API_PRODUCTS)
    public ResponseEntity<Product> saveProduct(@RequestBody AddProductRequest request) {
        Product savedProduct = productService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping(Statics.API_PRODUCTS + "/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable long id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(product);
    }

    @PatchMapping(Statics.API_PRODUCTS + "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody UpdateProductRequest request) {
        Product updatedProduct = productService.update(id, request);

        return ResponseEntity.ok().body(updatedProduct);

    }

}
