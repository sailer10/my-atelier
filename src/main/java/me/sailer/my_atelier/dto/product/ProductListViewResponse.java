package me.sailer.my_atelier.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.domain.ProductTag;
import me.sailer.my_atelier.domain.ProductTagMapping;
import me.sailer.my_atelier.enums.ProductStatus;

import java.util.*;

@Getter
public class ProductListViewResponse {
    private Long productNo;
    // ProductTagMapping entity 1:N
    private List<String> tags;
    // Atelier entity
    private String atelierName;
    private String productName;
    private int price;
    @JsonProperty("isDiscount")
    private boolean isDiscount;
    private int discountPrice;
    // ProductImage entity 에서 가져온 src
    private String mainImageSrc;

    public ProductListViewResponse(Long productNo, String productName, int price, boolean isDiscount,
            int discountPrice, String atelierName, String imageSrc, Object tagStr) {
        this.productNo = productNo;
        this.atelierName = atelierName;
        this.productName = productName;
        this.price = price;
        this.isDiscount = isDiscount;
        this.discountPrice = discountPrice;
        this.mainImageSrc = imageSrc;
        this.tags = getTagNameList(tagStr);
    }

    // 태그목록을 문자열로 한번에 받아온 뒤 Set으로 만듦
    private List<String> getTagNameList(Object tagStr) {
        if (tagStr == null)
            return Collections.emptyList();

        return Arrays.asList(tagStr.toString().split(","));
    }
}
