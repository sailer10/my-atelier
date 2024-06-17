package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Product 와 ProductTag 의 중간 테이블
 * 유저 - 오더 - 상품 . 이런 식으로 중간 테이블을 실무에서 반드시 만들어야 된다고 한다.
 * 근데 이 클래스는 중간에 로직을 딱히 넣을 필요 없을거 같긴 함
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductTagMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagMappingNo;

    @ManyToOne
    @JoinColumn(name="product_no", updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="product_tag_no", updatable = false)
    private ProductTag productTag;
}
