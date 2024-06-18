package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.statics.StaticUrls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AuctionViewController {


    @GetMapping(StaticUrls.PRODUCTS)
    public String getProducts(Model model) {

        return StaticUrls.AUCTION + StaticUrls.PRODUCTS;
    }

    @GetMapping(StaticUrls.PRODUCTS + "/{id}")
    public String getProductDetail(@PathVariable("id") long id, Model model) {
        // todo: service 에서 id 에 해당하는 상품 찾은 후 model.addAttribute("product", 찾은객체);

        return StaticUrls.AUCTION + StaticUrls.PRODUCT_DETAIL;
    }

}
