package me.sailer.my_atelier.dto.tag;

import lombok.Getter;
import me.sailer.my_atelier.domain.ProductTagMapping;

@Getter
public class ProductTagDto {

    private Long tagMappingNo;
    private Long productNo;
    private Long productTagNo;

//    public ProductTagDto(ProductTagMapping ptm) {
//        this.tagMappingNo = ptm.getTagMappingNo();
//        this.productNo = ptm.getP
//    }
}
