package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.domain.dto.AddProductRequest;
import me.sailer.my_atelier.service.AuctionService;
import me.sailer.my_atelier.statics.Statics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AutionApiController {

    private AuctionService auctionService;

    @PostMapping(Statics.API_PRODUCT)
    public ResponseEntity<Product> saveProduct(@RequestBody AddProductRequest request) {
        Product savedProduct = auctionService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping(Statics.API_PRODUCT + "/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable long id) {
        Product product = auctionService.findById(id);

        return ResponseEntity.ok().body(product);
    }

}
