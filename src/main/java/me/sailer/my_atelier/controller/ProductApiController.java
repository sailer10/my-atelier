package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.product.AddProductRequest;
import me.sailer.my_atelier.dto.product.ProductDetailResponse;
import me.sailer.my_atelier.dto.product.ProductListViewResponse;
import me.sailer.my_atelier.service.ProductService;
import me.sailer.my_atelier.util.Urls;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Urls.API_PRODUCTS)
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> getProduct(@PathVariable Long id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(new ProductDetailResponse(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductListViewResponse>> getProductListByCategory(@RequestParam(name = Urls.PARAM_CN) Byte categoryNo) {
        List<ProductListViewResponse> responses = productService.findProductListByCategory(categoryNo);
        return ResponseEntity.ok().body(responses);
    }

    // 아래 메소드는 이미지 없이 상품 내용 리스트로 받아오는 메소드임. 정상작동 테스트함.
//    @GetMapping
//    public ResponseEntity<List<ProductsListViewResponse>> getProductsByCategory(@RequestParam(name = Urls.PARAM_CN) Byte categoryNo) {
//        List<ProductsListViewResponse> responses = productService.findProductsListByCategory(categoryNo);
//        List<ProductDetailResponse> products = productService.findByCategory(categoryNo).stream().
//                map(ProductDetailResponse::new).toList(); // mam( v -> new ProductResponse(v))
//
//        return ResponseEntity.ok().body(products);
//    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequest request) {
        Product product = productService.saveProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }




}
