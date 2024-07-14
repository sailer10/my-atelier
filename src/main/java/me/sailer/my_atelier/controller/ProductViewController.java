package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.product.ProductDetailResponse;
import me.sailer.my_atelier.dto.product.ProductListViewResponse;
import me.sailer.my_atelier.service.ProductService;
import me.sailer.my_atelier.util.Urls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(Urls.URL_PRODUCTS)
@Slf4j
public class ProductViewController {

    private final ProductService productService;


    // 카테고리별 검색
    @GetMapping
    public String getProductsByCategory(@RequestParam(name = Urls.PARAM_CN, defaultValue = "1") Byte categoryNo, Model model) {
        List<ProductListViewResponse> responses = productService.findProductListByCategory(categoryNo);
        model.addAttribute("products", responses);
        log.debug(String.valueOf(responses.size()));
        return Urls.PRODUCTS;
    }

    // 특정 상품 검색
    @GetMapping("/{productNo}")
    public String getProductById(@PathVariable Long productNo, Model model) {
        Product product = productService.findById(productNo);
        model.addAttribute("product", new ProductDetailResponse(product));
        return Urls.PRODUCT_DETAIL;
    }
}
