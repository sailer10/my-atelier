package me.sailer.my_atelier.dto.productImage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import me.sailer.my_atelier.domain.ProductImage;

@Getter
public class ProductImagesResponse {
    private Long imageNo;
    private String imageSrc;
    private Long productNo;
    private boolean isMain;

    public ProductImagesResponse(ProductImage productImage, Long productNo) {
        this.imageNo = productImage.getImageNo();
        this.imageSrc = productImage.getImageSrc();
        this.productNo = productNo;
        this.isMain = productImage.isMain();
    }
}
