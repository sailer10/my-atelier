package me.sailer.my_atelier.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import me.sailer.my_atelier.domain.base.BaseTime;
import me.sailer.my_atelier.enums.ProductStatus;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "PRODUCT")
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no", updatable = false)
    private Long productNo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private final Set<ProductTagMapping> productTagMappings = new HashSet<>();

    @ManyToOne  // FetchType.EAGER 로 default 설정 되어있음.
                // LAZY로 하면 해당 객체가 사용되기 전까지 로딩되지 않고 프록시객체로 대체되는데
    @JoinColumn(name = "category_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "atelier_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Atelier atelier;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int remaining;  // 재고

    @Builder.Default
    @Column(name = "is_discount")
    @JsonProperty("isDiscount")
    private boolean isDiscount = false; // deafult 값 설정

    @Column(name = "discount_price")
    private int discountPrice;

    private String description;

    @Builder.Default
    private ProductStatus status = ProductStatus.EXPOSED;

    @Builder
    public Product(String name, int price, int remaining,
                   boolean isDiscount, int discountPrice, String description,
                   Category category, Atelier atelier) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.isDiscount = isDiscount;
        this.discountPrice = discountPrice;
        this.description = description;
        this.category = category;
        this.atelier = atelier;
    }

    public void update(String name, int price, int remaining, boolean isDiscount,
                       int discountPrice, Category category) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.isDiscount = isDiscount;
        this.discountPrice = discountPrice;
        this.category = category;
        // 생성 및 수정시각이 처음 상품 등록시에는 자동으로 적용 되지만, 수정시간은 직접 설정해야함
        this.setModifiedDateTime(LocalDateTime.now());
    }
}