package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.service.AuctionService;
import me.sailer.my_atelier.statics.Statics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuctionViewController {

    private final AuctionService auctionService;

    @GetMapping(Statics.PRODUCTS)
    public String getProducts(Model model) {

        return Statics.AUCTION + Statics.PRODUCTS;
    }

    @GetMapping(Statics.PRODUCTS + "/{id}")
    public String getProductDetail(@PathVariable("id") long id, Model model) {
        // todo: service 에서 id 에 해당하는 상품 찾은 후 model.addAttribute("product", 찾은객체);

        return Statics.AUCTION + Statics.PRODUCT_DETAIL;
    }

}
