package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.product.ProductResponse;
import me.sailer.my_atelier.service.ProductService;
import me.sailer.my_atelier.util.STS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(STS.URL_PRODUCTS)
public class ProductViewController {

    private final ProductService productService;


    // 카테고리별 검색
    @GetMapping
    public String getProductsByCategory(@RequestParam(name = STS.PARAM_CN, defaultValue = "1") Byte categoryNo, Model model) {
        List<ProductResponse> products = productService.findByCategory(categoryNo).stream().map(ProductResponse::new).toList();


        model.addAttribute("products", products);

        return STS.PRODUCTS;
    }

    // 특정 상품 검색
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long productNo, Model model) {
        Product product = productService.findById(productNo);
        model.addAttribute("product", new ProductResponse(product));
        return STS.PRODUCTS;
    }
}
