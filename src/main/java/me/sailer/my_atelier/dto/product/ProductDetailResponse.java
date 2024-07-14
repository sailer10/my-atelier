package me.sailer.my_atelier.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.domain.ProductTagMapping;
import me.sailer.my_atelier.enums.ProductStatus;

import java.util.List;
import java.util.Set;

@Getter
public class ProductDetailResponse {
    private Long productNo;
    private Set<ProductTagMapping> productTagMappings;
    private Long atelierNo;
    private String atelierName;
    private String productName;
    private int price;
    private int remaining;
    /**
     * get/post 요청 후에 앞의 is 가 사라지게 되는데 이는 java bean 명명규칙을 따르기 때문임
     * 이를 막기위해 @JsonProperty("is_discount") 로 직접 json key 값을 지어줌
     * 이러한 경우가 많아지면 @JsonNaming 어노테이션을 사용한다고 함
     */
    @JsonProperty("is_discount")
    private boolean isDiscount;
    private int discountPrice;
    private String description;
    private ProductStatus status;
    private List<String> imageSrc;

    public ProductDetailResponse(Product product) {
        this.productNo = product.getProductNo();
        this.productTagMappings = product.getProductTagMappings();
        this.atelierNo = product.getAtelier().getAtelierNo();
        this.atelierName = product.getAtelier().getName();
        this.productName = product.getName();
        this.price = product.getPrice();
        this.remaining = product.getRemaining();
        this.isDiscount = product.isDiscount();
        this.discountPrice = product.getDiscountPrice();
        this.description = product.getDescription();
        this.status = product.getStatus();
    }
}
