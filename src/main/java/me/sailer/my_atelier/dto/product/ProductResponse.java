package me.sailer.my_atelier.dto.product;

import lombok.Getter;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.domain.ProductTagMapping;
import me.sailer.my_atelier.enums.ProductStatus;

import java.util.Set;

@Getter
public class ProductResponse {
    private Long productNo;
    private Set<ProductTagMapping> productTagMappings;
    private Byte categoryNo;
    private Long atelierNo;
    private String name;
    private int price;
    private int remaining;
    private boolean isDiscount;
    private int discountPrice;
    private String description;
    private ProductStatus status;

    public ProductResponse(Product product) {
        this.productNo = product.getProductNo();
        this.productTagMappings = product.getProductTagMappings();
        this.categoryNo = product.getCategory().getCategory_no();
        this.atelierNo = product.getAtelier().getAtelier_no();
        this.name = product.getName();
        this.price = product.getPrice();
        this.remaining = product.getRemaining();
        this.isDiscount = product.isDiscount();
        this.discountPrice = product.getDiscountPrice();
        this.description = product.getDescription();
        this.status = product.getStatus();
    }
}
